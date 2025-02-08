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
}
