package com.ngoclinh.backendspring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_seq_generator")
    @SequenceGenerator(name = "unit_seq_generator", sequenceName = "units_id_seq", allocationSize = 1)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name="updated_date")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @JoinColumn(name = "created_by")
    @ManyToOne
    private Human createdBy;

    @JoinColumn(name="updated_by")
    @ManyToOne
    private Human updatedBy;
}
