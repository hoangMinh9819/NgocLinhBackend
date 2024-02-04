package com.ngoclinh.backendspring.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name="tbl_humans")
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "human_seq_generator")
    @SequenceGenerator(name = "human_seq_generator", sequenceName = "humans_id_seq", allocationSize = 1)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="phone")
    private String phone;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name="created_by")
    private Human createdBy;

    @ManyToOne
    @JoinColumn(name="updated_by")
    private Human updatedBy;

    @UpdateTimestamp
    @Column(name="created_date")
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name="updated_date")
    private LocalDateTime updatedDate;
}
