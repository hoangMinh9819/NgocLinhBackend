package com.ngoclinh.backendspring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_generator")
    @SequenceGenerator(name = "product_seq_generator", sequenceName = "products_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long productId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "PURCHASE_PRICE")
    private double purchasePrice;

    @ManyToOne
    @JoinColumn(name = "UNIT_PURCHASE")
    private Unit unitPurchase;

    @Column(name = "SALE_PRICE")
    private double salePrice;

    @ManyToOne
    @JoinColumn(name = "UNIT_SALE")
    private Unit unitSale;

    @Column(name = "packing")
    private Integer packing;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "EXPIRY")
    private LocalDateTime expiry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private Human createdBy;

    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPDATED_BY")
    private Human updatedBy;

    @Column(name = "UPDATE_DATE")
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<WareHouseDetails> warehouseDetailsList;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderDetails> oderDetailsList;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ReceiptDetails> receiptDetailsList;
}
