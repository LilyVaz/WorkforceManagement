package com.WorkforceManagement.WorkforceManagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.WorkforceManagement.WorkforceManagement.dto.EmpleadoDTO;
import com.WorkforceManagement.WorkforceManagement.model.Empleado;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {
    
   
    @Mappings({
        @Mapping(source = "afp.idEntidad", target = "afp"),// Mapea los IDs correctamente
        @Mapping(source = "formaPago.idFormaPago", target = "formaPago"),
        @Mapping(source = "persona.idPersona", target = "persona")
    
    })
    EmpleadoDTO toDTO(Empleado empleado);

     @Mappings({
        @Mapping(source = "afp", target = "afp.idEntidad"),
        @Mapping(source = "formaPago", target = "formaPago.idFormaPago"),
        @Mapping(source = "persona", target = "persona.idPersona")
     })
     Empleado toEntity(EmpleadoDTO empleadoDTO);
}
