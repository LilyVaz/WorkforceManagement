package com.WorkforceManagement.WorkforceManagement.service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

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
    public T saveWithRelations(T entity, Map<String, Object> foreignKeys) {
        foreignKeys.forEach((fieldName, repositoryAndId) -> {
            try {
                // Separar repositorio e ID
                Object[] repoAndId = (Object[]) repositoryAndId;
                JpaRepository<Object, Object> repository = (JpaRepository<Object, Object>) repoAndId[0];
                Object foreignId = repoAndId[1];

                // Buscar la entidad foránea
                Object foreignEntity = repository.findById(foreignId)
                        .orElseThrow(() -> new RuntimeException(fieldName + " no encontrado con ID: " + foreignId));

                // Asignar la entidad foránea al campo correspondiente
                Method setterMethod = entity.getClass()
                        .getMethod("set" + capitalize(fieldName), foreignEntity.getClass());
                setterMethod.invoke(entity, foreignEntity);
            } catch (Exception e) {
                throw new RuntimeException("Error asignando clave foránea: " + fieldName, e);
            }
        });

        // Guardar la entidad principal
        return getRepository().save(entity);
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}   
