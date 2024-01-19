package com.ngoclinh.backendspring.exception;

import com.ngoclinh.backendspring.exception.customException.DuplicateException;
import com.ngoclinh.backendspring.exception.customException.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

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
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateException(DuplicateException ex) {
        Map<String, String> response = new HashMap<>();
        response.put(ex.getFieldName(), ex.getMessage());
        return new ResponseEntity<>(new ErrorResponse("Lỗi trùng lặp dữ liệu",response), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundExceptionException(NotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put(ex.getFieldName(), ex.getMessage());
        return new ResponseEntity<>(new ErrorResponse("Lỗi không tìm thấy dữ liệu",response), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ErrorResponse handleNotFoundExceptionException(NoSuchElementException ex) {
        Map<String, String> response = new HashMap<>();
        response.put(ex.toString(), ex.getMessage());
        return new ErrorResponse("Lỗi không tìm thấy dữ liệu",response);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND);
    }
    private ResponseEntity<Object> buildErrorResponse(Exception ex, HttpStatus status) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("status", "error");
        errorDetails.put("message", ex.getMessage());
        return new ResponseEntity<>(errorDetails, status);
    }

}
