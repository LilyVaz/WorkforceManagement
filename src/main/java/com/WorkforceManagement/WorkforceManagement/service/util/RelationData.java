package com.WorkforceManagement.WorkforceManagement.service.util;

import org.springframework.data.jpa.repository.JpaRepository;

public class RelationData<R, ID> {
    private final JpaRepository<R, ID> repository;
    private final ID id;
    
    public RelationData(JpaRepository<R, ID> repository, ID id) {
        this.repository = repository;
        this.id = id;
    }

    public JpaRepository<R, ID> getRepository() {
        return repository;
    }

    public ID getId() {
        return id;
    }


    // 🔥 Nuevo método para obtener la entidad relacionada desde el repositorio
    public R getRelatedEntity() {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la entidad con ID: " + id));
    }
}
