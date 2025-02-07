package com.WorkforceManagement.WorkforceManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.WorkforceManagement.WorkforceManagement.dto.EmpleadoDTO;
import com.WorkforceManagement.WorkforceManagement.mapper.EmpleadoMapper;
import com.WorkforceManagement.WorkforceManagement.model.Empleado;
import com.WorkforceManagement.WorkforceManagement.model.Entidad;
import com.WorkforceManagement.WorkforceManagement.model.FormaPago;
import com.WorkforceManagement.WorkforceManagement.model.Persona;
import com.WorkforceManagement.WorkforceManagement.repository.EmpleadoRepository;
import com.WorkforceManagement.WorkforceManagement.repository.EntidadRepository;
import com.WorkforceManagement.WorkforceManagement.repository.FormaPagoRepository;
import com.WorkforceManagement.WorkforceManagement.repository.PersonaRepository;

@Service
public class EmpleadoService extends GenericService<Empleado, Integer>{
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private FormaPagoRepository formaPagoRepository;
    @Autowired
    private EntidadRepository entidadRepository;
    @Autowired
    private EmpleadoMapper empleadoMapper;

    @Override
    protected JpaRepository<Empleado, Integer>getRepository(){
        return empleadoRepository;
    }

    public EmpleadoDTO saveEmpleado(EmpleadoDTO empleadoDTO){
        Persona persona= personaRepository.findById(empleadoDTO.getPersona())
            .orElseThrow(()-> new RuntimeException("Persona no encontrada"));

        FormaPago formaPago= formaPagoRepository.findById(empleadoDTO.getFormaPago())
            .orElseThrow(()-> new RuntimeException("Forma de pago no encontrada"));
        
        Entidad entidad=entidadRepository.findById(empleadoDTO.getAfp())
            .orElseThrow(()-> new RuntimeException("AFP no encontrada"));
        
        Empleado empleado=empleadoMapper.toEntity(empleadoDTO);
        empleado.setPersona(persona);
        empleado.setFormaPago(formaPago);
        empleado.setAfp(entidad);

        Empleado saveEmpleado=empleadoRepository.save(empleado);

        return empleadoMapper.toDTO(saveEmpleado);
    }

    public EmpleadoDTO updateEmpleado(Integer idEmpleado, EmpleadoDTO empleadoDTO){
        Empleado empleadoUpdate=empleadoRepository.findById(idEmpleado)
            .orElseThrow(()-> new RuntimeException("Empleado no encontrado"));
        
        Persona persona= personaRepository.findById(empleadoDTO.getPersona())
            .orElseThrow(()-> new RuntimeException("Persona no encontrada"));

        FormaPago formaPago=formaPagoRepository.findById(empleadoDTO.getFormaPago())
            .orElseThrow(()-> new RuntimeException("Forma de pago no encontrada"));

        Entidad afp= entidadRepository.findById(empleadoDTO.getAfp())
            .orElseThrow(()-> new RuntimeException("Afp no encontrada"));

            empleadoUpdate=empleadoMapper.toEntity(empleadoDTO);
            empleadoUpdate.setIdEmpleado(idEmpleado);
            empleadoUpdate.setPersona(persona);
            empleadoUpdate.setFormaPago(formaPago);
            empleadoUpdate.setAfp(afp);
            empleadoUpdate.setCodigoEmpleado(empleadoDTO.getCodigoEmpleado());
            empleadoUpdate.setNumIsss(empleadoDTO.getNumIsss());
            empleadoUpdate.setNumNup(empleadoDTO.getNumNup());
            
            Empleado empleadoSave=empleadoRepository.save(empleadoUpdate);

            return empleadoMapper.toDTO(empleadoSave);
    }
}
