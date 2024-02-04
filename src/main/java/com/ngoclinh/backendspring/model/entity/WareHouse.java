package com.ngoclinh.backendspring.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tbl_ware_houses")
public class WareHouse {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "create_by")
    private Human createdBy;

    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @JoinColumn(name = "updated_by")
    @ManyToOne
    private Human updatedBy;

    @Column(name = "updated_date")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "wareHouseId")
    private List<WareHouseDetails> wareHouseDetailsList;
}
