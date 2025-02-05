package com.WorkforceManagement.WorkforceManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "empleadocargos")
public class EmpleadoCargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_empleadocargo")
    private Integer idEmpleadoCargo;

    @Column(nullable = false, length = 30)
    private String empleadoCargo;
}
