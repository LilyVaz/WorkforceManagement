package com.WorkforceManagement.WorkforceManagement.service;
/*
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.WorkforceManagement.WorkforceManagement.model.Contrato;
import com.WorkforceManagement.WorkforceManagement.repository.CatDepartamentoRepository;
import com.WorkforceManagement.WorkforceManagement.repository.ContratoRepository;
import com.WorkforceManagement.WorkforceManagement.repository.EmpleadoCargoRepository;
import com.WorkforceManagement.WorkforceManagement.repository.EmpleadoRepository;
import com.WorkforceManagement.WorkforceManagement.repository.TipoContratoRepository;
import com.WorkforceManagement.WorkforceManagement.service.util.RelationData;

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
  

    @Override
    protected JpaRepository<Contrato, Integer>getRepository(){
        return contratoRepository;
    }

    /*public ContratoDTO saveContrato(ContratoDTO contratoDTO){
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
    public ContratoDTO updateContrato(Integer idContrato, ContratoDTO contratoDTO){
        Contrato contratoUpdate=contratoRepository.findById(idContrato)
            .orElseThrow(()-> new RuntimeException("No se encontro el contrato"));
        
        Empleado empleado=empleadoRepository.findById(contratoDTO.getEmpleado())
            .orElseThrow(()-> new RuntimeException("Empleado no encontrado"));
        
        TipoContrato tipoContrato= tipoContratoRepository.findById(contratoDTO.getTipoContrato())
            .orElseThrow(()-> new RuntimeException("Tipo de contrato no encontrado"));
        
        EmpleadoCargo empleadoCargo= empleadoCargoRepository.findById(contratoDTO.getEmpleadoCargo())
            .orElseThrow(()-> new RuntimeException("Cargo no encontrado"));
        
        CatDepartamento catDepartamento=catDepartamentoRepository.findById(contratoDTO.getCatDepartamento())
            .orElseThrow(()-> new RuntimeException("Categoria de departamento no encontrada"));
            
            contratoUpdate=contratoMapper.toEntity(contratoDTO);
            contratoDTO.setIdContrato(idContrato); 
            contratoUpdate.setEmpleado(empleado);
            contratoUpdate.setTipoContrato(tipoContrato);
            contratoUpdate.setEmpleadoCargo(empleadoCargo);
            contratoUpdate.setCatDepartamento(catDepartamento);
            contratoUpdate.setFechaInicio(contratoDTO.getFechaInicio());
            contratoUpdate.setSalario(contratoDTO.getSalario());
            contratoUpdate.setFechaFin(contratoDTO.getFechaFin());

            Contrato contratoSave=contratoRepository.save(contratoUpdate);

            return contratoMapper.toDTO(contratoSave);
    }*/
   /* public Contrato saveContrato(Contrato contrato) {
        Map<String, RelationData<?, ?>> foreignKeys = getRelationMap(contrato);
        return saveWithRelations(contrato, foreignKeys, this::validateContrato);
    }

    //  🔵 Actualizar contrato con relaciones
    public Contrato updateContrato(Integer id, Contrato contrato) {
        Map<String, RelationData<?, ?>> foreignKeys = getRelationMap(contrato);
        return updateWithRelations(id, contrato, foreignKeys, this::validateContrato);
    }

    // 🔍 Método para obtener relaciones del contrato
    private Map<String, RelationData<?, ?>> getRelationMap(Contrato contrato) {
        Map<String, RelationData<?, ?>> foreignKeys = new HashMap<>();
        foreignKeys.put("empleado", new RelationData<>(empleadoRepository, contrato.getEmpleado().getIdEmpleado()));
        foreignKeys.put("tipoContrato", new RelationData<>(tipoContratoRepository, contrato.getTipoContrato().getIdTipoContrato()));
        foreignKeys.put("empleadoCargo", new RelationData<>(empleadoCargoRepository, contrato.getEmpleadoCargo().getIdEmpleadoCargo()));
        foreignKeys.put("catDepartamento", new RelationData<>(catDepartamentoRepository, contrato.getCatDepartamento().getIdCatDepartamento()));
        return foreignKeys;
    }

    // 🔍 Validaciones previas a guardar/actualizar
    private Contrato validateContrato(Contrato contrato) {
        if (contrato.getSalario() <= 0) {
            throw new RuntimeException("El salario debe ser mayor a 0");
        }
        return contrato;
    }
} */
