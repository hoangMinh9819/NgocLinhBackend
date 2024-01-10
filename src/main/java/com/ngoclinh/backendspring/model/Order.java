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
@Table(name="TBL_Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ORDER_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name="CREATED_BY")
    private Human createdBy;
    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    private Human customerId;
    @ManyToOne
    @JoinColumn(name="UPDATED_BY")
    private Human updatedBy;
    @Column(name="CREATED_DATE")
    @CreationTimestamp
    private LocalDateTime createdDate;
    @Column(name="UPDATED_DATE")
    @UpdateTimestamp
    private LocalDateTime updatedDate;
    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetailsList;
}
