package com.WorkforceManagement.WorkforceManagement.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "contratos")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrato")
    private Integer idContrato;
    
    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contrato", nullable = false)
    private TipoContrato tipoContrato;

    @ManyToOne
    @JoinColumn(name = "id_empleado_cargo")
    private EmpleadoCargo empleadoCargo;

    @ManyToOne
    @JoinColumn(name = "id_cat_departamento")
    private CatDepartamento catDepartamento;

    private Date fechaInicio;

    private Double salario;

    private Date fechaFin;

}
