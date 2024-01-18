package com.ngoclinh.backendspring.exception.customException;

import lombok.Getter;

@Getter
public class DuplicateUnitException extends RuntimeException{
    private String fieldName;
    public DuplicateUnitException(String fieldName,String message) {
        super(message);
        this.fieldName=fieldName;
    }
}
