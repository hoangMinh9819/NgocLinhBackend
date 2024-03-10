package com.ngoclinh.backendspring.mapper;

import com.ngoclinh.backendspring.model.dto.WareHouseDTO;
import com.ngoclinh.backendspring.model.dto.WareHouseDetailsDTO;
import com.ngoclinh.backendspring.model.entity.WareHouse;
import com.ngoclinh.backendspring.model.entity.WareHouseDetails;
import com.ngoclinh.backendspring.repository.ProductRepository;
import com.ngoclinh.backendspring.repository.UnitRepository;
import com.ngoclinh.backendspring.repository.WareHouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WareHouseDetailsMapper {
    final private WareHouseRepository wareHouseRepository;
    final private ProductRepository productRepository;
    public WareHouseDetails toEntity(WareHouseDetailsDTO dto){
        WareHouseDetails entity = new WareHouseDetails();
        entity.setWareHouseId(wareHouseRepository.findById(dto.getWareHouseId()).get());
        entity.setProductId(productRepository.findById(dto.getProductId()).get());
        entity.setQuantity(dto.getQuantity());
        return entity;
    }

    public WareHouseDetailsDTO toDto(WareHouseDetails entity){
        WareHouseDetailsDTO dto = new WareHouseDetailsDTO();
        dto.setWareHouseId(entity.getWareHouseId().getId());
        dto.setProductId(entity.getProductId().getId());
        dto.setProductName(entity.getProductId().getName());
        dto.setQuantity(entity.getQuantity());
        return dto;
    }
}
