package com.ngoclinh.backendspring.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Data
@NoArgsConstructor
@Table(name="tbl_order_details")
@IdClass(OrderDetailsID.class)
public class OrderDetails {
    @Id
    @ManyToOne
    @JoinColumn(name="order_id", insertable = false, updatable = false)
    private Order orderId;
    @Id
    @ManyToOne
    @JoinColumn(name="product_id", insertable = false, updatable = false)
    private Product productId;

    @Column(name="quantity")
    private Integer quantity;
}
