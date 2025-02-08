package com.WorkforceManagement.WorkforceManagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.WorkforceManagement.WorkforceManagement.dto.ContratoDTO;
import com.WorkforceManagement.WorkforceManagement.model.Contrato;

@Mapper(componentModel = "spring")
public interface ContratoMapper {
    
    @Mappings({
        @Mapping(source = "empleado.idEmpleado", target = "empleado"),
        @Mapping(source = "tipoContrato.idTipoContrato", target = "tipoContrato"),
        @Mapping(source = "empleadoCargo.idEmpleadoCargo", target = "empleadoCargo"),
        @Mapping(source = "catDepartamento.idCatDepartamento", target = "catDepartamento")
    })
    ContratoDTO toDTO(Contrato contrato);

    @Mappings({
        @Mapping(source = "empleado", target = "empleado.idEmpleado"),
        @Mapping(source = "tipoContrato", target = "tipoContrato.idTipoContrato"),
        @Mapping(source = "empleadoCargo", target = "empleadoCargo.idEmpleadoCargo"),
        @Mapping(source = "catDepartamento", target = "catDepartamento.idCatDepartamento")
    })
    Contrato toEntity(ContratoDTO contratoDTO);
}
