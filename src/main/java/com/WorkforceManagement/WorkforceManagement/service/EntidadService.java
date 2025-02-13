 package com.WorkforceManagement.WorkforceManagement.service;

import org.springframework.stereotype.Service;
import com.WorkforceManagement.WorkforceManagement.dto.EntidadDTO;
import com.WorkforceManagement.WorkforceManagement.mapper.EntidadMapper;
import com.WorkforceManagement.WorkforceManagement.model.Entidad;
import com.WorkforceManagement.WorkforceManagement.repository.EntidadRepository;

@Service
public class EntidadService extends GenericService<Entidad, EntidadDTO, Integer>{
   
    public EntidadService(EntidadRepository repository, EntidadMapper mapper) {
        super(repository, mapper); // 🔥 Llamar al constructor de la superclase
    }

}
