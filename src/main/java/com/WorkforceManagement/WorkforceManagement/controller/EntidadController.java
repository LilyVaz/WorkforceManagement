package com.WorkforceManagement.WorkforceManagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.WorkforceManagement.WorkforceManagement.dto.EntidadDTO;
import com.WorkforceManagement.WorkforceManagement.model.Entidad;
import com.WorkforceManagement.WorkforceManagement.service.EntidadService;

@RestController
@RequestMapping("/entidades")
public class EntidadController extends GenericController<Entidad, EntidadDTO, Integer>{
    

    public EntidadController(EntidadService service){
        super(service);
    }

}
 