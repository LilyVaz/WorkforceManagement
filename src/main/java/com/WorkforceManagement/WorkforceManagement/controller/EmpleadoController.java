package com.WorkforceManagement.WorkforceManagement.controller;
/*
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WorkforceManagement.WorkforceManagement.dto.EmpleadoDTO;
import com.WorkforceManagement.WorkforceManagement.mapper.GenericMapper;
import com.WorkforceManagement.WorkforceManagement.model.Empleado;
import com.WorkforceManagement.WorkforceManagement.service.EmpleadoService;
import com.WorkforceManagement.WorkforceManagement.service.GenericService;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController extends GenericController<Empleado, Integer, EmpleadoDTO>{
    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService=empleadoService;
    }

    @Override
    protected GenericService<Empleado, Integer>getService(){
        return empleadoService;
    }

    @PostMapping("/create")
    public ResponseEntity<EmpleadoDTO> saveEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
        return ResponseEntity.ok(empleadoService.saveEmpleado(empleadoDTO));
    }

    @PutMapping("/update/{idEmpleado}")
    public ResponseEntity<EmpleadoDTO>update(@PathVariable Integer idEmpleado, @RequestBody EmpleadoDTO empleadoDTO){
        EmpleadoDTO updateEmpleado=empleadoService.updateEmpleado(idEmpleado, empleadoDTO);
        return updateEmpleado!=null?ResponseEntity.ok(updateEmpleado):ResponseEntity.notFound().build();
    }

    @Override
    protected GenericMapper<Empleado, EmpleadoDTO> getMapper() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMapper'");
    }

    @Override
    protected EmpleadoDTO toDTO(Empleado entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toDTO'");
    }

    @Override
    protected Empleado toEntity(EmpleadoDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }
}*/
