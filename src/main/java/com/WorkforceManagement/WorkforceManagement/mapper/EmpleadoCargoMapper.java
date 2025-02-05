package com.WorkforceManagement.WorkforceManagement.mapper;

import org.mapstruct.Mapper;

import com.WorkforceManagement.WorkforceManagement.dto.EmpleadoCargoDTO;
import com.WorkforceManagement.WorkforceManagement.model.EmpleadoCargo;

@Mapper(componentModel = "spring")
public interface EmpleadoCargoMapper {
    EmpleadoCargoDTO toDTO(EmpleadoCargo empleadoCargo);
    EmpleadoCargo toEntity(EmpleadoCargoDTO empleadoCargoDTO);
}
