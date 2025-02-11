package com.WorkforceManagement.WorkforceManagement.controller;
/*
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorkforceManagement.WorkforceManagement.dto.EntidadDTO;
import com.WorkforceManagement.WorkforceManagement.mapper.GenericMapper;
import com.WorkforceManagement.WorkforceManagement.model.Entidad;
import com.WorkforceManagement.WorkforceManagement.service.EntidadService;
import com.WorkforceManagement.WorkforceManagement.service.GenericService;

@RestController
@RequestMapping("/api/entidades")
public class EntidadController extends GenericController<Entidad, Integer, EntidadDTO>{
    
    private final EntidadService entidadService;

    public EntidadController(EntidadService entidadService){
        this.entidadService=entidadService;
    }

    @Override
    protected GenericService<Entidad, Integer>getService(){
        return entidadService;
    }


    @PostMapping("/create")
    public ResponseEntity<EntidadDTO> saveEntidad(@RequestBody EntidadDTO entidadDTO) {
        return ResponseEntity.ok(entidadService.saveEntidad(entidadDTO));
    }


    @PutMapping("/update/{idEntidad}")
    public ResponseEntity<EntidadDTO>update(@PathVariable Integer idEntidad, @RequestBody EntidadDTO entidadDTO){
        EntidadDTO updateEntidad= entidadService.updateEntidad(idEntidad, entidadDTO);
        return updateEntidad!=null?ResponseEntity.ok(updateEntidad): ResponseEntity.notFound().build();
    }

    @Override
    protected GenericMapper<Entidad, EntidadDTO> getMapper() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMapper'");
    }

    @Override
    protected EntidadDTO toDTO(Entidad entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toDTO'");
    }

    @Override
    protected Entidad toEntity(EntidadDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }
}
 */