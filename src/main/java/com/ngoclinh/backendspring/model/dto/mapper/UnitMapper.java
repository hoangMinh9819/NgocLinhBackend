package com.ngoclinh.backendspring.model.dto.mapper;

import com.ngoclinh.backendspring.model.Unit;
import com.ngoclinh.backendspring.model.dto.UnitDTO;

public class UnitMapper {
    public static UnitDTO convertToDto(Unit unit){
        UnitDTO unitDTO = new UnitDTO();
        unitDTO.setId(unit.getId());
        unitDTO.setName(unit.getName());
        return unitDTO;
    }
    public static Unit convertToEntity(UnitDTO unitDTO){
        Unit unit = new Unit();
        unit.setName(unitDTO.getName());
        return unit;
    }
}
