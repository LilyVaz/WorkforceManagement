package com.WorkforceManagement.WorkforceManagement.service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WorkforceManagement.WorkforceManagement.service.util.RelationData;

public abstract class GenericService<T, ID> {
    protected abstract JpaRepository<T, ID> getRepository();

    public List<T> findAll(){
        return getRepository().findAll();
    }

    public T findById(ID id) {
        return getRepository().findById(id).orElseThrow(() -> new RuntimeException("Registro no encontrado"));
    }

    public T save(T entity){
        return getRepository().save(entity);
    }

    public void deleteById(ID id){
        getRepository().deleteById(id);
    }

    @SuppressWarnings("unchecked")
    public T saveWithRelations(T entity, Map<String, RelationData<?, ?>> foreignKeys) {
        foreignKeys.forEach((fieldName, relationData) -> {
            try {
                // Obtener el repositorio y ID desde RelationData
                JpaRepository<Object, Object> repository = (JpaRepository<Object, Object>) relationData.getRepository();
                Object foreignId = relationData.getId();
    
                // Buscar la entidad foránea
                Object foreignEntity = repository.findById(foreignId)
                        .orElseThrow(() -> new RuntimeException(fieldName + " no encontrado con ID: " + foreignId));
    
                // Invocar el método "setter" de forma explícita y segura
                invokeSetter(entity, fieldName, foreignEntity);
            } catch (Exception e) {
                throw new RuntimeException("Error asignando clave foránea: " + fieldName, e);
            }
        });
    
        // Guardar la entidad principal
        return getRepository().save(entity);
    }
    
    private <E> void invokeSetter(T entity, String fieldName, E foreignEntity) throws Exception {
        // Obtener el método "setter" del campo relacionado
        Method setterMethod = entity.getClass()
                .getMethod("set" + capitalize(fieldName), foreignEntity.getClass());
        // Invocar el método "setter" para asignar la relación
        setterMethod.invoke(entity, foreignEntity);
    }
    
    private String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}   
