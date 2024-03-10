package com.ngoclinh.backendspring.model.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tbl_ware_house_details")
@IdClass(WareHouseDetailsID.class)
public class WareHouseDetails {
    @Id
    @ManyToOne
    @JoinColumn(name="warehouse_id")
    private WareHouse wareHouseId;

    @Id
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product productId;

    @Column(name = "quantity")
    private Integer quantity;
}
