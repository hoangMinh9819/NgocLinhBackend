package com.ngoclinh.backendspring.mapper;

import com.ngoclinh.backendspring.model.dto.ProductDTO;
import com.ngoclinh.backendspring.model.entity.Product;
import com.ngoclinh.backendspring.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    final private UnitRepository unitRepository;
    public ProductDTO toDto(Product entity){
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSupplier(entity.getSupplier());
        dto.setExpiry(entity.getExpiry());
        dto.setPurchasePrice(entity.getPurchasePrice());
        dto.setSalePrice(entity.getSalePrice());
        if(entity.getUnitSale()!=null) {
            dto.setUnitSale(entity.getUnitSale().getName());
        }else{
            dto.setUnitSale(null);
        }
        if (entity.getUnitPurchase() != null) {
            dto.setUnitPurchase(entity.getUnitPurchase().getName());
        } else {
            dto.setUnitPurchase(null);
        }
        dto.setPacking(entity.getPacking());
        return dto;
    }
    public Product toEntity(ProductDTO dto){
        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setSupplier(dto.getSupplier());
        entity.setExpiry(dto.getExpiry());
        entity.setPurchasePrice(dto.getPurchasePrice());
        entity.setSalePrice(dto.getSalePrice());
        entity.setUnitSale(unitRepository.findUnitByName(dto.getUnitSale()));
        entity.setUnitPurchase(unitRepository.findUnitByName(dto.getUnitPurchase()));
        entity.setPacking(dto.getPacking());
        return entity;
    }
}
