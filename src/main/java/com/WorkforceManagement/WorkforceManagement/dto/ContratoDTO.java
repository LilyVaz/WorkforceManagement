package com.WorkforceManagement.WorkforceManagement.dto;

import java.sql.Date;
import lombok.Data;

@Data
public class ContratoDTO {
    private Integer idEmpleado;
    private Integer idTipoContrato;
    private Integer idEmpleadoCargo;
    private Integer idCatDepartamento;
    private Date fechaInicio;
    private Double salario;
    private Date fechaFin;
}
