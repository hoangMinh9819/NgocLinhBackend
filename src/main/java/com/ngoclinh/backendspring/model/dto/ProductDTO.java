package com.ngoclinh.backendspring.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private String supplier;
    private Double purchasePrice;
    private Double salePrice;
    private String unitSale;
    private String unitPurchase;
    private Integer packing;
    private LocalDate expiry;
}
