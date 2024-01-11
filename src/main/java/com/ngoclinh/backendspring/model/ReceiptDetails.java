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
@Table(name = "tbl_receipt_details")
public class ReceiptDetails {
    @EmbeddedId
    private ReceiptDetailsID receiptDetailsID;
    @Column(name = "QUANTITY")
    private int quantity;

    @ManyToOne
    @MapsId("receiptId")
    @JoinColumn(name="receipt_id")
    private Receipt receipt;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="product_id")
    private Product product;


}
