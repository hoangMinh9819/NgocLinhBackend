package com.ngoclinh.backendspring.mapper;

import com.ngoclinh.backendspring.model.dto.HumanDTO;
import com.ngoclinh.backendspring.model.entity.Human;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HumanMapper {
    public HumanDTO toDto(Human entity){
        HumanDTO dto = new HumanDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setPhone(entity.getPhone());
        dto.setUsername(entity.getUsername());
        dto.setPassword(null);
        dto.setRole(entity.getRole());
        return dto;
    }
    public Human toEntity(HumanDTO dto){
        Human entity = new Human();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setRole(dto.getRole());
        return entity;
    }
}
