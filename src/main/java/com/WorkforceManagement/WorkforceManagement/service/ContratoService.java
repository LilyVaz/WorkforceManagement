package com.WorkforceManagement.WorkforceManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.WorkforceManagement.WorkforceManagement.dto.ContratoDTO;
import com.WorkforceManagement.WorkforceManagement.mapper.ContratoMapper;
import com.WorkforceManagement.WorkforceManagement.model.CatDepartamento;
import com.WorkforceManagement.WorkforceManagement.model.Contrato;
import com.WorkforceManagement.WorkforceManagement.model.Empleado;
import com.WorkforceManagement.WorkforceManagement.model.EmpleadoCargo;
import com.WorkforceManagement.WorkforceManagement.model.TipoContrato;
import com.WorkforceManagement.WorkforceManagement.repository.CatDepartamentoRepository;
import com.WorkforceManagement.WorkforceManagement.repository.ContratoRepository;
import com.WorkforceManagement.WorkforceManagement.repository.EmpleadoCargoRepository;
import com.WorkforceManagement.WorkforceManagement.repository.EmpleadoRepository;
import com.WorkforceManagement.WorkforceManagement.repository.TipoContratoRepository;

@Service
public class ContratoService extends GenericService<Contrato, Integer>{
    @Autowired
    private ContratoRepository contratoRepository;
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private TipoContratoRepository tipoContratoRepository;
    @Autowired
    private EmpleadoCargoRepository empleadoCargoRepository;
    @Autowired
    private CatDepartamentoRepository catDepartamentoRepository;
    @Autowired
    private ContratoMapper contratoMapper;

    @Override
    protected JpaRepository<Contrato, Integer>getRepository(){
        return contratoRepository;
    }

    public ContratoDTO saveContrato(ContratoDTO contratoDTO){
        Empleado empleado=empleadoRepository.findById(contratoDTO.getEmpleado())
            .orElseThrow(()-> new RuntimeException("Empleado no encontrado"));
        
        TipoContrato tipoContrato= tipoContratoRepository.findById(contratoDTO.getTipoContrato())
            .orElseThrow(()-> new RuntimeException("Tipo de contrato no encontrado"));
        
        EmpleadoCargo empleadoCargo= empleadoCargoRepository.findById(contratoDTO.getEmpleadoCargo())
            .orElseThrow(()-> new RuntimeException("Cargo no encontrado"));
        
        CatDepartamento catDepartamento=catDepartamentoRepository.findById(contratoDTO.getCatDepartamento())
            .orElseThrow(()-> new RuntimeException("Categoria de departamento no encontrada"));
        
        Contrato contrato =contratoMapper.toEntity(contratoDTO);
        contrato.setEmpleado(empleado);
        contrato.setTipoContrato(tipoContrato);
        contrato.setEmpleadoCargo(empleadoCargo);
        contrato.setCatDepartamento(catDepartamento);

        Contrato saveContrato=contratoRepository.save(contrato);

        return contratoMapper.toDTO(saveContrato);
    }
}
