package com.WorkforceManagement.WorkforceManagement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorkforceManagement.WorkforceManagement.dto.PersonaDTO;
import com.WorkforceManagement.WorkforceManagement.mapper.PersonaMapper;
import com.WorkforceManagement.WorkforceManagement.model.Persona;
import com.WorkforceManagement.WorkforceManagement.repository.PersonaRepository;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private PersonaMapper personaMapper;

    public List<PersonaDTO> listAll(){
        List<Persona> personas = personaRepository.findAll();
        return personas.stream()
                        .map(personaMapper::tDto)
                        .collect(Collectors.toList());
    }

    public PersonaDTO findById(Integer idPersona){
        Optional <Persona> persona=personaRepository.findById(idPersona);
        return persona.map(personaMapper::tDto).orElse(null);
    }

    public PersonaDTO save(PersonaDTO personaDTO){
        Persona persona= personaMapper.toEntity(personaDTO);
        Persona savePersona= personaRepository.save(persona);
        return personaMapper.tDto(savePersona);
    }

    /*public PersonaDTO update(Integer idPersona, PersonaDTO personaDTO){
        Persona persona = personaRepository.findById(idPersona)
            .orElseThrow(()-> new RuntimeException("No se encontro a la persona con Id "+idPersona));
            persona.setNombre(personaDTO.getNombre());
            persona.setApellido(personaDTO.getApellido());
            persona.setDui(personaDTO.getDui());
            persona.setNit(personaDTO.getNit());
            persona.setTelefono(personaDTO.getTelefono());
            persona.setCorreo(personaDTO.getCorreo());

            Persona personaUpdate = personaRepository.save(persona);
            return personaMapper.tDto(personaUpdate);
    }*/

    public PersonaDTO update(Integer idPersona, PersonaDTO personaDTO){
        Persona personaUpdate=personaRepository.findById(idPersona)
            .orElseThrow(()-> new RuntimeException("No se encontro el registro"));

            personaUpdate=personaMapper.toEntity(personaDTO);
            personaUpdate.setIdPersona(idPersona);

            Persona personaSave=personaRepository.save(personaUpdate);

            return personaMapper.tDto(personaSave);
    }

    public void delete(Integer idPersona){
        personaRepository.deleteById(idPersona);
    }

}
