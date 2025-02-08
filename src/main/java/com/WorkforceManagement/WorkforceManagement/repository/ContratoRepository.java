package com.WorkforceManagement.WorkforceManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WorkforceManagement.WorkforceManagement.model.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Integer>{
    
}
