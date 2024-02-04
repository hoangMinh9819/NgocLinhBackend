package com.ngoclinh.backendspring.exception;

import com.ngoclinh.backendspring.exception.customException.DuplicateException;
import jakarta.persistence.EntityNotFoundException;
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
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<Object> handleDuplicateException(DuplicateException ex) {
        return buildErrorResponse(ex, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND);
    }
    private ResponseEntity<Object> buildErrorResponse(Exception ex, HttpStatus status) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("status", status.name());
        errorDetails.put("message", ex.getMessage());
        return new ResponseEntity<>(errorDetails, status);
    }

}
