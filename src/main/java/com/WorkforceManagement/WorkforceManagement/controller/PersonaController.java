package com.WorkforceManagement.WorkforceManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorkforceManagement.WorkforceManagement.dto.PersonaDTO;
import com.WorkforceManagement.WorkforceManagement.model.Persona;
import com.WorkforceManagement.WorkforceManagement.service.GenericService;
import com.WorkforceManagement.WorkforceManagement.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController extends GenericController<Persona, Integer>{
    
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
}
