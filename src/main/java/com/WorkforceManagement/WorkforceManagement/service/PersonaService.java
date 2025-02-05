package com.WorkforceManagement.WorkforceManagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.WorkforceManagement.WorkforceManagement.dto.PersonaDTO;
import com.WorkforceManagement.WorkforceManagement.mapper.PersonaMapper;
import com.WorkforceManagement.WorkforceManagement.model.Persona;
import com.WorkforceManagement.WorkforceManagement.repository.PersonaRepository;

@Service
public class PersonaService extends GenericService<Persona, Integer> {
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private PersonaMapper personaMapper;

    @Override
    protected JpaRepository<Persona, Integer>getRepository(){
        return personaRepository;
    }

    public PersonaDTO update(Integer idPersona, PersonaDTO personaDTO){
        Persona personaUpdate=personaRepository.findById(idPersona)
            .orElseThrow(()-> new RuntimeException("No se encontro el registro"));

            personaUpdate=personaMapper.toEntity(personaDTO);
            personaUpdate.setIdPersona(idPersona);

            Persona personaSave=personaRepository.save(personaUpdate);

            return personaMapper.tDto(personaSave);
    }

}
