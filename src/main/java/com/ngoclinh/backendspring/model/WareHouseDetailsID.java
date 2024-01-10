package com.ngoclinh.backendspring.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class WareHouseDetailsID implements Serializable {
    private Long wareHouseId;
    private Long productId;
}
