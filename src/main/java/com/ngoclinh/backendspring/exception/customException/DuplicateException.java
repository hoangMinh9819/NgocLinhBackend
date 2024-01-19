package com.ngoclinh.backendspring.exception.customException;

import lombok.Getter;

@Getter
public class DuplicateException extends RuntimeException{
    private String fieldName;
    public DuplicateException(String fieldName, String message) {
        super(message);
        this.fieldName=fieldName;
    }
}
