package com.WorkforceManagement.WorkforceManagement.controller;
/*/
import org.springframework.web.bind.annotation.*;

import com.WorkforceManagement.WorkforceManagement.dto.PersonaDTO;
import com.WorkforceManagement.WorkforceManagement.model.Persona;
import com.WorkforceManagement.WorkforceManagement.service.PersonaService;
import com.WorkforceManagement.WorkforceManagement.service.util.RelationData;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/personas")
public class PersonaController extends GenericController<Persona, PersonaDTO, Integer> {

    public PersonaController(PersonaService service) {
        super(service);
    }

    @Override
    protected Map<String, RelationData<?, ?>> mapToRelationData(Map<String, Object> foreignKeys) {
        // Si Persona tuviera relaciones con otras entidades, se mapearían aquí
        return new HashMap<>();
    }
}*/