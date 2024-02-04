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
@Table(name="tbl_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="human_id")
    private Human humanId;

    @ManyToOne
    @JoinColumn(name="created_by")
    private Human createdBy;

    @ManyToOne
    @JoinColumn(name="updated_by")
    private Human updatedBy;

    @Column(name="created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name="updated_date")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "orderId")
    private List<OrderDetails> orderDetailsList;
}
