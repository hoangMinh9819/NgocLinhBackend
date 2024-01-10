package com.ngoclinh.backendspring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_units")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="NAME", nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private Human createdBy;
    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;
    @ManyToOne
    @JoinColumn(name="UPDATED_BY")
    private Human updatedBy;
    @Column(name="UPDATED_DATE")
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
