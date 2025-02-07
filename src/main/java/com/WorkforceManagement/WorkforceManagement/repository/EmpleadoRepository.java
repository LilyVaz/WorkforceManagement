package com.WorkforceManagement.WorkforceManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WorkforceManagement.WorkforceManagement.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
    
}
