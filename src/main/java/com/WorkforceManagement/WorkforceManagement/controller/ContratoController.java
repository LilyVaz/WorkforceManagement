package com.WorkforceManagement.WorkforceManagement.controller;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.WorkforceManagement.WorkforceManagement.model.Contrato;
import com.WorkforceManagement.WorkforceManagement.repository.CatDepartamentoRepository;
import com.WorkforceManagement.WorkforceManagement.repository.EmpleadoCargoRepository;
import com.WorkforceManagement.WorkforceManagement.repository.EmpleadoRepository;
import com.WorkforceManagement.WorkforceManagement.repository.TipoContratoRepository;
import com.WorkforceManagement.WorkforceManagement.service.ContratoService;
import com.WorkforceManagement.WorkforceManagement.service.util.RelationData;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/contratos")
public class ContratoController extends GenericController<Contrato, Integer> {

    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private TipoContratoRepository tipoContratoRepository;
    @Autowired
    private EmpleadoCargoRepository empleadoCargoRepository;
    @Autowired
    private CatDepartamentoRepository catDepartamentoRepository;

    public ContratoController(ContratoService service) {
        super(service);
    }

    @Override
    protected Map<String, RelationData<?, ?>> mapToRelationData(Map<String, Object> foreignKeys) {
        Map<String, RelationData<?, ?>> relationDataMap = new HashMap<>();

        if (foreignKeys.containsKey("empleadoId")) {
            relationDataMap.put("empleado", new RelationData<>(empleadoRepository, Integer.parseInt(foreignKeys.get("empleadoId").toString())));
        }
        if (foreignKeys.containsKey("tipoContratoId")) {
            relationDataMap.put("tipoContrato", new RelationData<>(tipoContratoRepository, Integer.parseInt(foreignKeys.get("tipoContratoId").toString())));
        }
        if (foreignKeys.containsKey("empleadoCargoId")) {
            relationDataMap.put("empleadoCargo", new RelationData<>(empleadoCargoRepository, Integer.parseInt(foreignKeys.get("empleadoCargoId").toString())));
        }
        if (foreignKeys.containsKey("catDepartamentoId")) {
            relationDataMap.put("catDepartamento", new RelationData<>(catDepartamentoRepository, Integer.parseInt(foreignKeys.get("catDepartamentoId").toString())));
        }

        return relationDataMap;
    }
}*/

/* 
    @PostMapping("/create")
public ResponseEntity<ContratoDTO> saveContrato(@RequestBody ContratoDTO contratoDTO) {
    return ResponseEntity.ok(contratoService.saveContrato(contratoDTO));
}

@PutMapping("/update/{idContrato}")
public ResponseEntity<ContratoDTO> updateContrato(
        @PathVariable Integer idContrato,
        @RequestBody ContratoDTO contratoDTO) {
    return ResponseEntity.ok(contratoService.updateContrato(idContrato, contratoDTO));
}


*/