package com.WorkforceManagement.WorkforceManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.WorkforceManagement.WorkforceManagement.dto.EntidadDTO;
import com.WorkforceManagement.WorkforceManagement.mapper.EntidadMapper;
import com.WorkforceManagement.WorkforceManagement.model.Entidad;
import com.WorkforceManagement.WorkforceManagement.model.Rubro;
import com.WorkforceManagement.WorkforceManagement.repository.EntidadRepository;
import com.WorkforceManagement.WorkforceManagement.repository.RubroRepository;

@Service
public class EntidadService extends GenericService<Entidad, Integer>{
    @Autowired
    private EntidadRepository entidadRepository;
    @Autowired
    private RubroRepository rubroRepository;

    @Autowired
    private EntidadMapper entidadMapper;

    @Override
    protected JpaRepository<Entidad, Integer>getRepository(){
        return entidadRepository;
    }

    public EntidadDTO saveEntidad(EntidadDTO entidadDTO){
        Rubro rubro= rubroRepository.findById(entidadDTO.getIdRubro())
        .orElseThrow(()-> new RuntimeException("Rubro no encontrado"));

        Entidad entidad = entidadMapper.toEntity(entidadDTO);
        entidad.setRubro(rubro);

        Entidad saveEntidad= entidadRepository.save(entidad);

        return entidadMapper.toDTO(saveEntidad);
    }

    public EntidadDTO updateEntidad(Integer idEntidad, EntidadDTO entidadDTO){
        Entidad entidadUpdate=entidadRepository.findById(idEntidad)
            .orElseThrow(()-> new RuntimeException("No se encontro el registro"));

        Rubro rubro= rubroRepository.findById(entidadDTO.getIdRubro())
            .orElseThrow(()-> new RuntimeException("Rubro no encontrado"));

            entidadUpdate=entidadMapper.toEntity(entidadDTO);
            entidadUpdate.setIdEntidad(idEntidad);
            entidadUpdate.setRubro(rubro);

            Entidad entidadSave=entidadRepository.save(entidadUpdate);

            return entidadMapper.toDTO(entidadSave);
    }
}
