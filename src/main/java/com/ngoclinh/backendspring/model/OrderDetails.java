package com.ngoclinh.backendspring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_Order_Details")
public class OrderDetails {
    @EmbeddedId
    private OrderDetailsID orderDetailsID;
    @Column(name="QUANTITY")
    private int quantity;
    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name="ORDER_ID")
    private Order order;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="PRODUCT_ID")
    private Product product;
}
