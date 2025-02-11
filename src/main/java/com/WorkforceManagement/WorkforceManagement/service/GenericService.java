package com.WorkforceManagement.WorkforceManagement.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.WorkforceManagement.WorkforceManagement.mapper.GenericMapper;
import com.WorkforceManagement.WorkforceManagement.service.util.RelationData;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class GenericService<T, DTO, ID> {

    @Autowired
    protected JpaRepository<T, ID> repository;

    @Autowired
    protected GenericMapper<T, DTO> mapper; // 🔥 MapStruct para conversión

    // 1️⃣ **Listar todos los registros**
    public List<DTO> listAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    // 2️⃣ **Buscar por ID**
    public DTO findById(ID id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado con ID: " + id));
    }

    // 3️⃣ **Guardar nuevo registro**
    @Transactional
    public DTO save(DTO dto) {
        T entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    // 4️⃣ **Actualizar un registro existente**
    @Transactional
public DTO update(ID id, DTO dto) {
    return repository.findById(id)
        .map(existingEntity -> {  // 🔹 `existingEntity` es de tipo `T`
            T updatedEntity = mapper.toEntity(dto);  // 🔥 Convertir DTO a entidad
            mergeEntities(existingEntity, updatedEntity); // 🔥 Actualizar solo los valores cambiados
            return repository.save(existingEntity); // 🔹 `map()` espera que devolvamos `T`
        })
        .map(mapper::toDTO)  // 🔥 Convertimos `T` a `DTO` después de guardar
        .orElseThrow(() -> new RuntimeException("Registro no encontrado con ID: " + id));
}


    // 5️⃣ **Eliminar un registro**
    @Transactional
    public void delete(ID id) {
        repository.deleteById(id);
    }

    // 6️⃣ **Guardar un registro con relaciones**
    @Transactional
    public DTO saveWithRelations(DTO dto, Map<String, RelationData<?, ?>> foreignKeys, Function<T, T> preSave) {
        T entity = mapper.toEntity(dto);
        assignRelations(entity, foreignKeys);
        T savedEntity = repository.save(preSave.apply(entity));
        return mapper.toDTO(savedEntity);
    }

    // 7️⃣ **Actualizar un registro con relaciones**

    @Transactional
public DTO updateWithRelations(ID id, DTO dto, Map<String, RelationData<?, ?>> foreignKeys, Function<T, T> preUpdate) {
    return repository.findById(id)
        .map(existingEntity -> {  // 🔹 `existingEntity` es de tipo `T`
            T updatedEntity = mapper.toEntity(dto);
            mergeEntities(existingEntity, updatedEntity);
            assignRelations(existingEntity, foreignKeys);
            return repository.save(preUpdate.apply(existingEntity));  // 🔹 Retornamos `T`
        })
        .map(mapper::toDTO)  // 🔥 Convertimos `T` a `DTO` después de guardar
        .orElseThrow(() -> new RuntimeException("Registro no encontrado con ID: " + id));
}


    // 🔍 **Método auxiliar para copiar valores de una entidad a otra**
    private void mergeEntities(T existingEntity, T updatedEntity) {
        // Copiar valores usando Reflection
        for (Method method : updatedEntity.getClass().getMethods()) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
                try {
                    Object value = method.invoke(updatedEntity);
                    if (value != null) {
                        String setterName = "set" + method.getName().substring(3);
                        Method setter = existingEntity.getClass().getMethod(setterName, method.getReturnType());
                        setter.invoke(existingEntity, value);
                    }
                } catch (Exception ignored) { }
            }
        }
    }

    // 🔍 **Método para asignar relaciones dinámicamente**
    private void assignRelations(T entity, Map<String, RelationData<?, ?>> foreignKeys) {
        foreignKeys.forEach((fieldName, relationData) -> {
            try {
                JpaRepository<Object, Object> repository = (JpaRepository<Object, Object>) relationData.getRepository();
                Object foreignId = relationData.getId();
    
                Optional<Object> optionalForeignEntity = repository.findById(foreignId);
                Object foreignEntity = optionalForeignEntity
                        .orElseThrow(() -> new RuntimeException(fieldName + " no encontrado con ID: " + foreignId));
    
                Method setter = entity.getClass().getMethod("set" + capitalize(fieldName), foreignEntity.getClass());
                setter.invoke(entity, foreignEntity);
            } catch (Exception e) {
                throw new RuntimeException("Error asignando relación: " + fieldName, e);
            }
        });
    }
    

    
    // 🔤 Método auxiliar para capitalizar la primera letra
    private String capitalize(String str) {
        return str == null || str.isEmpty() ? str : str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
