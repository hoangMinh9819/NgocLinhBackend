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
@Table(name = "tbl_ware_house_details")
public class WareHouseDetails {
    @EmbeddedId
    private WareHouseDetailsID wareHouseDetailsID;
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @MapsId("wareHouseId")
    @JoinColumn(name="receipt_id")
    private WareHouse wareHouse;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name="product_id")
    private Product product;
}
