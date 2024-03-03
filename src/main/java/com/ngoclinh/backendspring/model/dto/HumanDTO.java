package com.ngoclinh.backendspring.model.dto;

import com.ngoclinh.backendspring.model.entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HumanDTO {
    private Long id;

    private String name;

    private String address;

    private String phone;

    private String username;

    private String password;

    private Role role;
}
