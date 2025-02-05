package com.WorkforceManagement.WorkforceManagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Persona") 
    private Integer idPersona;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(nullable = false, length = 30)
    private String apellido;

    @Column(nullable = false, unique = true, length = 9)
    private String dui;

    @Column(nullable = false, unique = true, length = 17)
    private String nit;

    @Column(nullable = false, length = 8)
    private String telefono;

    @Column(nullable = false, length = 50)
    private String correo;

}
