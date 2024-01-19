package com.ngoclinh.backendspring.exception.customException;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException{
    private String fieldName;
    public NotFoundException(String fieldName,String message) {
        super(message);
        this.fieldName=fieldName;
    }
}
