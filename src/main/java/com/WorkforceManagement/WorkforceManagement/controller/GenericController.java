package com.WorkforceManagement.WorkforceManagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.WorkforceManagement.WorkforceManagement.service.GenericService;

public abstract class GenericController<T, ID> {
    protected abstract GenericService<T, ID> getService();

    @GetMapping
    public List<T> findAll(){
        return getService().findAll();
    }

    @GetMapping("/{id}")
    public T findById(@PathVariable ID id){
        return getService().findById(id);
    }
    
    @PostMapping
    public T save(@RequestBody T entity){
        return getService().save(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ID id){
        getService().deleteById(id);
    }
}
