package com.WorkforceManagement.WorkforceManagement.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.WorkforceManagement.WorkforceManagement.service.GenericService;
import java.util.List;

public abstract class GenericController<T, DTO, ID> {
    protected final GenericService<T, DTO, ID> service;
    public GenericController(GenericService<T, DTO, ID> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DTO>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable ID id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody DTO dto) {
        try {
            return ResponseEntity.ok(service.save(dto));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody DTO dto) {
        try {
            return ResponseEntity.ok(service.update(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ID id) {
        try {
            service.delete(id);
        return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    protected T preSaveValidation(T entity) {
        return entity;  // Puede ser sobreescrito en controladores específicos
    }

    protected T preUpdateValidation(T entity) {
        return entity;  // Puede ser sobreescrito en controladores específicos
    }
}
