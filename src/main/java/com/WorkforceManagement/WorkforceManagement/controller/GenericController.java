package com.WorkforceManagement.WorkforceManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.WorkforceManagement.WorkforceManagement.repository.CatDepartamentoRepository;
import com.WorkforceManagement.WorkforceManagement.repository.EmpleadoCargoRepository;
import com.WorkforceManagement.WorkforceManagement.repository.EmpleadoRepository;
import com.WorkforceManagement.WorkforceManagement.repository.TipoContratoRepository;
import com.WorkforceManagement.WorkforceManagement.service.GenericService;
import com.WorkforceManagement.WorkforceManagement.service.util.RelationData;

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

    private EmpleadoRepository empleadoRepository;
    private TipoContratoRepository tipoContratoRepository;
    private EmpleadoCargoRepository empleadoCargoRepository;
    private CatDepartamentoRepository catDepartamentoRepository;
    @PostMapping("/relations")
public T saveRelations(
        @RequestBody T entity,
        @RequestParam Integer empleado,
        @RequestParam Integer tipoContrato,
        @RequestParam Integer empleadoCargo,
        @RequestParam Integer catDepartamento) {

    // Construir el mapa de relaciones manualmente
    Map<String, RelationData<?, ?>> foreignKeys = Map.of(
        "empleado", new RelationData<>(empleadoRepository, empleado),
        "tipoContrato", new RelationData<>(tipoContratoRepository, tipoContrato),
        "empleadoCargo", new RelationData<>(empleadoCargoRepository, empleadoCargo),
        "catDepartamento", new RelationData<>(catDepartamentoRepository, catDepartamento)
    );

    return getService().saveWithRelations(entity, foreignKeys);
}


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ID id){
        getService().deleteById(id);
    }
} 
