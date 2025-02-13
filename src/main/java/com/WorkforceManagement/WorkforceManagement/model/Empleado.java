package com.WorkforceManagement.WorkforceManagement.model;

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
@Table(name = "empleados")
public class Empleado{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    private Integer codigoEmpleado;

    @ManyToOne
    @JoinColumn(name = "id_forma_pago", nullable = false)
    private FormaPago formaPago;

    private Integer numIsss;

    @ManyToOne
    @JoinColumn(name = "afp", nullable = false)
    private Entidad afp;

    private Integer numNup;

}
