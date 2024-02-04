package com.ngoclinh.backendspring.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnitDTO {
    private Long id;
    @NotBlank(message = "Name không được để trống")
    private String name;
}
