package com.WorkforceManagement.WorkforceManagement.dto;

import java.sql.Date;
import lombok.Data;

@Data
public class ContratoDTO {
    private Integer idContrato;
    private Integer empleado;
    private Integer tipoContrato;
    private Integer empleadoCargo;
    private Integer catDepartamento;
    private Date fechaInicio;
    private Double salario;
    private Date fechaFin;
}
