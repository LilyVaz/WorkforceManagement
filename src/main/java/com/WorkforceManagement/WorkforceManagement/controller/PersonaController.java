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
import com.WorkforceManagement.WorkforceManagement.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController{
    
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<PersonaDTO> listAll(){
        return personaService.listAll();
    }

    @GetMapping("/{idPersona}")
    public ResponseEntity<PersonaDTO> findById(@PathVariable Integer idPersona){
        PersonaDTO personaDTO=personaService.findById(idPersona);
        return personaDTO!=null? ResponseEntity.ok(personaDTO): ResponseEntity.notFound().build();
    }

    @PostMapping
    public PersonaDTO create(@RequestBody PersonaDTO personaDTO){
        return personaService.save(personaDTO);
    }

    @PutMapping("/{idPersona}")
    public ResponseEntity<PersonaDTO>update(@PathVariable Integer idPersona, @RequestBody PersonaDTO personaDTO){
        PersonaDTO updatePersona=personaService.update(idPersona, personaDTO);
        return updatePersona!= null?ResponseEntity.ok(updatePersona): ResponseEntity.notFound().build();
    }  

    @DeleteMapping("/{idPersona}")
    public ResponseEntity<Void> delete(@PathVariable Integer idPersona){
        personaService.delete(idPersona);
        return ResponseEntity.noContent().build();
    }
}
