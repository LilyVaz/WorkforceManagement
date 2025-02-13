package com.WorkforceManagement.WorkforceManagement.controller;
/*/
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorkforceManagement.WorkforceManagement.dto.EmpleadoDTO;
import com.WorkforceManagement.WorkforceManagement.model.Empleado;
import com.WorkforceManagement.WorkforceManagement.service.EmpleadoService;
import com.WorkforceManagement.WorkforceManagement.service.util.RelationData;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController extends GenericController<Empleado, EmpleadoDTO, Integer>{
    public EmpleadoController(EmpleadoService service){
        super(service);
    }

    @Override
    protected Map<String, RelationData<?,?>> mapToRelationData(Map<String, Object> foreignKeys){
        return new HashMap<>();
    }
}*/
