package com.ngoclinh.backendspring.mapper;

import com.ngoclinh.backendspring.model.entity.Unit;
import com.ngoclinh.backendspring.model.dto.UnitDTO;

public class UnitMapper {

    public static Unit toEntity(UnitDTO dto){
        Unit entity = new Unit();
        entity.setName(dto.getName());
        return entity;
    }

    public static UnitDTO toDto(Unit unit){
        UnitDTO dto = new UnitDTO();
        dto.setId(unit.getId());
        dto.setName(unit.getName());
        return dto;
    }


}
