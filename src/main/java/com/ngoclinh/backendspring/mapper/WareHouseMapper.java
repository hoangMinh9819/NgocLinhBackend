package com.ngoclinh.backendspring.mapper;

import com.ngoclinh.backendspring.model.dto.UnitDTO;
import com.ngoclinh.backendspring.model.dto.WareHouseDTO;
import com.ngoclinh.backendspring.model.entity.Unit;
import com.ngoclinh.backendspring.model.entity.WareHouse;

public class WareHouseMapper {
    public static WareHouse toEntity(WareHouseDTO dto){
        WareHouse entity = new WareHouse();
        entity.setName(dto.getName());
        return entity;
    }

    public static WareHouseDTO toDto(WareHouse entity){
        WareHouseDTO dto = new WareHouseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
