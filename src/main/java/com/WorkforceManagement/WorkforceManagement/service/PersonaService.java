package com.WorkforceManagement.WorkforceManagement.service;


import org.springframework.stereotype.Service;

import com.WorkforceManagement.WorkforceManagement.dto.PersonaDTO;
import com.WorkforceManagement.WorkforceManagement.mapper.PersonaMapper;
import com.WorkforceManagement.WorkforceManagement.model.Persona;
import com.WorkforceManagement.WorkforceManagement.repository.PersonaRepository;

@Service
public class PersonaService extends GenericService<Persona, PersonaDTO, Integer> {
    
    public PersonaService(PersonaRepository repository, PersonaMapper mapper){
        this.repository=repository;
        this.mapper=mapper;
    }


}
