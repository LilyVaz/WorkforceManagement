package com.WorkforceManagement.WorkforceManagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    
}
