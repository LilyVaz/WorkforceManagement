package com.WorkforceManagement.WorkforceManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.WorkforceManagement.WorkforceManagement.dto.EmpleadoCargoDTO;
import com.WorkforceManagement.WorkforceManagement.mapper.EmpleadoCargoMapper;
import com.WorkforceManagement.WorkforceManagement.model.EmpleadoCargo;
import com.WorkforceManagement.WorkforceManagement.repository.EmpleadoCargoRepository;

@Service
public class EmpleadoCargoService extends GenericService<EmpleadoCargo, Integer> {
    @Autowired
    private EmpleadoCargoRepository empleadoCargoRepository;
    @Autowired
    private EmpleadoCargoMapper empleadoCargoMapper;

    @Override
    protected JpaRepository<EmpleadoCargo, Integer>getRepository(){
        return empleadoCargoRepository;
    }

    public EmpleadoCargoDTO update(Integer idEmpleadpCargo, EmpleadoCargoDTO empleadoCargoDTO){
        EmpleadoCargo empleadoCargoUpdate= empleadoCargoRepository.findById(idEmpleadpCargo)
            .orElseThrow(()-> new RuntimeException("No se encontro el registro"));

            empleadoCargoUpdate=empleadoCargoMapper.toEntity(empleadoCargoDTO);
            empleadoCargoUpdate.setIdEmpleadoCargo(idEmpleadpCargo);

            EmpleadoCargo empleadoCargoSave=empleadoCargoRepository.save(empleadoCargoUpdate);

            return empleadoCargoMapper.toDTO(empleadoCargoSave);
    }

}
