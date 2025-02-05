package com.WorkforceManagement.WorkforceManagement.mapper;

import org.mapstruct.Mapper;

import com.WorkforceManagement.WorkforceManagement.dto.PersonaDTO;
import com.WorkforceManagement.WorkforceManagement.model.Persona;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaDTO tDto(Persona persona);
    Persona toEntity(PersonaDTO personaDTO);

}
