package com.WorkforceManagement.WorkforceManagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.WorkforceManagement.WorkforceManagement.dto.EntidadDTO;
import com.WorkforceManagement.WorkforceManagement.model.Entidad;

@Mapper(componentModel = "spring")
public interface EntidadMapper extends GenericMapper<Entidad, EntidadDTO>{

    @Mappings({
        @Mapping(source = "rubro.idRubro", target = "rubro")
    })
    EntidadDTO toDTO(Entidad entidad);

    @Mappings({
        @Mapping(source = "rubro", target = "rubro.idRubro")
    })
    Entidad toEntity(EntidadDTO entidadDTO);
}
