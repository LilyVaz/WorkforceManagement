package com.WorkforceManagement.WorkforceManagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorkforceManagement.WorkforceManagement.dto.ContratoDTO;
import com.WorkforceManagement.WorkforceManagement.model.Contrato;
import com.WorkforceManagement.WorkforceManagement.service.ContratoService;
import com.WorkforceManagement.WorkforceManagement.service.GenericService;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController extends GenericController<Contrato, Integer> {
    private final ContratoService contratoService;

    public ContratoController (ContratoService contratoService){
        this.contratoService=contratoService;
    }

    @Override
    protected GenericService<Contrato, Integer>getService(){
        return contratoService;
    }

    @PostMapping("/create")
    public ResponseEntity<ContratoDTO> saveContrato(@RequestBody ContratoDTO contratoDTO){
        return ResponseEntity.ok(contratoService.saveContrato(contratoDTO));
    }
    
    @PutMapping("/update/{idContrato}")
    public ResponseEntity<ContratoDTO>update(@PathVariable Integer idContrato, @RequestBody ContratoDTO contratoDTO){
        ContratoDTO updateContrato=contratoService.updateContrato(idContrato, contratoDTO);
        return updateContrato!=null?ResponseEntity.ok(updateContrato): ResponseEntity.notFound().build();

    }
}
