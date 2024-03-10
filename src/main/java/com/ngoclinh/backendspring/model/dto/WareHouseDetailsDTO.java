package com.ngoclinh.backendspring.model.dto;

import com.ngoclinh.backendspring.model.entity.Product;
import com.ngoclinh.backendspring.model.entity.WareHouse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WareHouseDetailsDTO {
    private Long wareHouseId;
    private Long productId;
    private String productName;
    private Integer quantity;
}
