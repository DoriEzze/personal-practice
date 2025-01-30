package com.meli.config;

import com.meli.exceptions.InvalidSystemException;
import com.meli.exceptions.SystemAlreadyDamagedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(SystemAlreadyDamagedException.class)
    public ResponseEntity<Map<String, String>> handleSystemAlreadyDamaged(SystemAlreadyDamagedException ex) {
        return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidSystemException.class)
    public ResponseEntity<Map<String, String>> handleInvalidSystem(InvalidSystemException ex) {
        return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Unexpected error"));
    }
}
