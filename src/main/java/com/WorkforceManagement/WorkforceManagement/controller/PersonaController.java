package com.WorkforceManagement.WorkforceManagement.controller;
/*
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorkforceManagement.WorkforceManagement.dto.PersonaDTO;
import com.WorkforceManagement.WorkforceManagement.mapper.GenericMapper;
import com.WorkforceManagement.WorkforceManagement.model.Persona;
import com.WorkforceManagement.WorkforceManagement.service.GenericService;
import com.WorkforceManagement.WorkforceManagement.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController extends GenericController<Persona, Integer, PersonaDTO>{
    
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService){
        this.personaService=personaService;
    }

    @Override
    protected GenericService<Persona, Integer>getService(){
        return personaService;
    }

    @PutMapping("/{idPersona}")
    public ResponseEntity<PersonaDTO>update(@PathVariable Integer idPersona, @RequestBody PersonaDTO personaDTO){
        PersonaDTO updatePersona=personaService.update(idPersona, personaDTO);
        return updatePersona!= null?ResponseEntity.ok(updatePersona): ResponseEntity.notFound().build();
    }

    @Override
    protected GenericMapper<Persona, PersonaDTO> getMapper() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMapper'");
    }

    @Override
    protected PersonaDTO toDTO(Persona entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toDTO'");
    }

    @Override
    protected Persona toEntity(PersonaDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }  
}
 */