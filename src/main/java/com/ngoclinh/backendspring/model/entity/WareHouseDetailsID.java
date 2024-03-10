package com.ngoclinh.backendspring.model.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class WareHouseDetailsID implements Serializable {
    private Long wareHouseId;
    private Long productId;
}
