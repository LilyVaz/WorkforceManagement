package com.WorkforceManagement.WorkforceManagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.WorkforceManagement.WorkforceManagement.service.GenericService;
import com.WorkforceManagement.WorkforceManagement.service.util.RelationData;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public abstract class GenericController<T, ID> {

    protected final GenericService<T, ID> service;

    public GenericController(GenericService<T, ID> service) {
        this.service = service;
    }

    // 1️⃣ Obtener todos los registros
    @GetMapping
    public ResponseEntity<List<T>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // 2️⃣ Obtener un registro por ID
    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable ID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // 3️⃣ Guardar nuevo registro sin relaciones
    @PostMapping
    public ResponseEntity<T> save(@RequestBody T entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    // 4️⃣ Actualizar un registro existente sin relaciones
    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity) {
        return ResponseEntity.ok(service.update(id, entity));
    }

    // 5️⃣ Eliminar un registro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // 6️⃣ Guardar una entidad con relaciones
    @PostMapping("/save-with-relations")
    public ResponseEntity<T> saveWithRelations(
            @RequestBody T entity,
            @RequestParam Map<String, Object> foreignKeys) {

        Map<String, RelationData<?, ?>> relationDataMap = mapToRelationData(foreignKeys);
        Function<T, T> preSaveOrUpdate = this::preSaveValidation;

        return ResponseEntity.ok(service.saveWithRelations(entity, relationDataMap, preSaveOrUpdate));
    }

    // 7️⃣ 🔥 **Actualizar una entidad con relaciones**
    @PutMapping("/update-with-relations/{id}")
    public ResponseEntity<T> updateWithRelations(
            @PathVariable ID id,
            @RequestBody T entity,
            @RequestParam Map<String, Object> foreignKeys) {

        Map<String, RelationData<?, ?>> relationDataMap = mapToRelationData(foreignKeys);
        Function<T, T> preSaveOrUpdate = this::preSaveValidation;

        return ResponseEntity.ok(service.updateWithRelations(id, entity, relationDataMap, preSaveOrUpdate));
    }

    // 🔍 Método abstracto para convertir `foreignKeys` en `RelationData`
    protected abstract Map<String, RelationData<?, ?>> mapToRelationData(Map<String, Object> foreignKeys);

    // 🔍 Método para validaciones antes de guardar/actualizar (puede ser sobrescrito)
    protected T preSaveValidation(T entity) {
        return entity; // Por defecto, no hace nada (puede ser personalizado en subclases)
    }
}
