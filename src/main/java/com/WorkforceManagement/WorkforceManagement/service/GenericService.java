package com.WorkforceManagement.WorkforceManagement.service;

import java.util.List;

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
}   
