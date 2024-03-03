package com.ngoclinh.backendspring.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name="tbl_units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    @NotBlank
    private String name;

    @Column(name = "created_date", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name="updated_date", insertable = false)
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @JoinColumn(name = "created_by")
    @ManyToOne
    private Human createdBy;

    @JoinColumn(name="updated_by")
    @ManyToOne
    private Human updatedBy;
}
