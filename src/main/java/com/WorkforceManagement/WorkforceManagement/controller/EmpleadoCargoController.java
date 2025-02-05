package com.WorkforceManagement.WorkforceManagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorkforceManagement.WorkforceManagement.dto.EmpleadoCargoDTO;
import com.WorkforceManagement.WorkforceManagement.model.EmpleadoCargo;
import com.WorkforceManagement.WorkforceManagement.service.EmpleadoCargoService;
import com.WorkforceManagement.WorkforceManagement.service.GenericService;

@RestController
@RequestMapping("/api/empleadocargo")
public class EmpleadoCargoController extends GenericController<EmpleadoCargo, Integer> {
    
    private final EmpleadoCargoService empleadoCargoService;

    public EmpleadoCargoController(EmpleadoCargoService empleadoCargoService){
        this.empleadoCargoService= empleadoCargoService;
    }

    @Override
    protected GenericService<EmpleadoCargo, Integer>getService(){
        return empleadoCargoService;
    }

    @PutMapping("/{idEmpleadoCargo}")
    public ResponseEntity<EmpleadoCargoDTO>update(@PathVariable Integer idEmpleadoCargo, @RequestBody EmpleadoCargoDTO empleadoCargoDTO){
        EmpleadoCargoDTO updateEmpleadoCargoDTO=empleadoCargoService.update(idEmpleadoCargo, empleadoCargoDTO);
        return updateEmpleadoCargoDTO!=null?ResponseEntity.ok(updateEmpleadoCargoDTO): ResponseEntity.notFound().build();
    }
}
