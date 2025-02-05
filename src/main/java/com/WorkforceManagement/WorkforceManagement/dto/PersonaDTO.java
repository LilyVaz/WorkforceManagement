package com.WorkforceManagement.WorkforceManagement.dto;

import lombok.Data;

@Data
public class PersonaDTO {
    private Integer idPersona;
    private String nombre;
    private String apellido;
    private String dui;
    private String nit;
    private String telefono;
    private String correo;
}
