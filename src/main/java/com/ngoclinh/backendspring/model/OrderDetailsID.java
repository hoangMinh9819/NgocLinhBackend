package com.ngoclinh.backendspring.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDetailsID implements Serializable {
    private Long orderId;
    private Long productId;
}
