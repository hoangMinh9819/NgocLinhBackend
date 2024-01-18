package com.ngoclinh.backendspring.exception;

import com.ngoclinh.backendspring.exception.customException.DuplicateUnitException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(new ErrorResponse("Lỗi nhập từ người dùng",errors), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DuplicateUnitException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateAccountException(DuplicateUnitException ex) {
        Map<String, String> response = new HashMap<>();
        response.put(ex.getFieldName(), ex.getMessage());
        return new ResponseEntity<>(new ErrorResponse("Lỗi trùng lặp dữ liệu",response), HttpStatus.CONFLICT);
    }
}
