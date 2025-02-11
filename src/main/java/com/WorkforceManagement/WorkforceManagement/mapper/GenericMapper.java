package com.WorkforceManagement.WorkforceManagement.mapper;

import java.util.List;

public interface GenericMapper<T, DTO> {
    DTO toDTO(T entity);
    T toEntity(DTO dto);

    List<DTO> toDTOList(List<T> entityList);
    List<T> toEntityList(List<DTO> dtoList);
}