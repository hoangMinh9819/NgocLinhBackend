package com.ngoclinh.backendspring.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "tbl_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proid_seq")
    @SequenceGenerator(name = "proid_seq", sequenceName = "products_id_sequence",  allocationSize=1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "purchase_price")
    private Double purchasePrice;

    @ManyToOne
    @JoinColumn(name = "unit_purchase")
    private Unit unitPurchase;

    @Column(name = "sale_price")
    private Double salePrice;

    @ManyToOne
    @JoinColumn(name = "unit_sale")
    private Unit unitSale;

    @Column(name = "packing")
    private Integer packing;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "expiry")
    private LocalDate expiry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private Human createdBy;

    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by")
    private Human updatedBy;

    @Column(name = "updated_date")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

}
