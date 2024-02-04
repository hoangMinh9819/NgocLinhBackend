package com.ngoclinh.backendspring.exception.customException;

import lombok.Getter;

@Getter
public class DuplicateException extends RuntimeException{
    public DuplicateException(String message) {
        super(message);
    }
}
