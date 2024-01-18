package com.ngoclinh.backendspring.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
        private String errorType;
        private Map<String, String> details;
}


