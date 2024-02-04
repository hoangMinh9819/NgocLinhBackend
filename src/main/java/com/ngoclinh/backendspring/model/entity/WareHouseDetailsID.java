package com.ngoclinh.backendspring.model.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class WareHouseDetailsID implements Serializable {
    private WareHouse wareHouseId;
    private Product productId;
}
