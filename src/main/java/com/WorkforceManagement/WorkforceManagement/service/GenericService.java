package com.WorkforceManagement.WorkforceManagement.service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.WorkforceManagement.WorkforceManagement.mapper.GenericMapper;
import jakarta.persistence.Entity;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericService<T, DTO, ID> {
    protected final JpaRepository<T, ID> repository;
    protected final GenericMapper<T, DTO> mapper;

    public GenericService(JpaRepository<T, ID> repository, GenericMapper<T, DTO> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<DTO> listAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public DTO findById(ID id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado con ID: " + id));
    }

    @Transactional
    public DTO save(DTO dto) {
        T entity = mapper.toEntity(dto);
        entity=preSaveValidation(entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional
    public DTO update(ID id, DTO dto) {
    return repository.findById(id)
        .map(existingEntity -> {  // 🔹 `existingEntity` es de tipo `T`
            T updatedEntity = mapper.toEntity(dto);  // 🔥 Convertir DTO a entidad
            updatedEntity=preUpdateValidation(existingEntity);
            mergeEntities(existingEntity, updatedEntity); // 🔥 Actualizar solo los valores cambiados
            return repository.save(existingEntity); // 🔹 `map()` espera que devolvamos `T`
        })
        .map(mapper::toDTO)  // 🔥 Convertimos `T` a `DTO` después de guardar
        .orElseThrow(() -> new RuntimeException("Registro no encontrado con ID: " + id));
}

    @Transactional
    public void delete(ID id) {
        repository.deleteById(id);
    }

   private void mergeEntities(T existingEntity, T updatedEntity) {
        for (Method getter : updatedEntity.getClass().getMethods()) {
            if (getter.getName().startsWith("get") && getter.getParameterCount() == 0) {
                try {
                    Object value = getter.invoke(updatedEntity);
                    if (value != null) {
                        String setterName = "set" + getter.getName().substring(3);
                        Method setter = existingEntity.getClass().getMethod(setterName, getter.getReturnType());
    
                        // 🔥 Evitar actualizar relaciones para evitar problemas en JPA
                        if (!getter.getReturnType().isAnnotationPresent(Entity.class)) {
                            setter.invoke(existingEntity, value);
                        }
                    }
                } catch (NoSuchMethodException e) {
                    System.err.println("No existe el método setter para: " + getter.getName());
                } catch (Exception e) {
                    throw new RuntimeException("Error actualizando campo: " + getter.getName(), e);
                }
            }
        }
    }

    // 🔥 Métodos opcionales para validaciones en cada servicio
    protected T preSaveValidation(T entity) {
        return entity;  // 🔹 Se puede sobrescribir en los servicios específicos
    }

    protected T preUpdateValidation(T entity) {
        return entity;  // 🔹 Se puede sobrescribir en los servicios específicos
    }

}
