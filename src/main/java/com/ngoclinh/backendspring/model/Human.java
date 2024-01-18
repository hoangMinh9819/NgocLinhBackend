package com.ngoclinh.backendspring.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_humans")
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="human_id")
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="PHONE")
    private String phone;
    @Column(name="USERNAME")
    private String username;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne
    @JoinColumn(name="created_by")
    private Human createdBy;
    @UpdateTimestamp
    @Column(name="created_date")
    private LocalDateTime createdDate;
    @ManyToOne
    @JoinColumn(name="UPDATED_BY")
    private Human updatedBy;
    @UpdateTimestamp
    @Column(name="UPDATED_DATE")
    private LocalDateTime updatedDate;
}
