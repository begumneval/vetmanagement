package com.begumneval.vetmanagement.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound(NotFoundException ex) {
        // Değerlendirme formu 26 ve 27: Exception ve anlamlı HTTP yanıt
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleBusiness(BusinessException ex) {
        // Değerlendirme formu 26 ve 27: Exception ve anlamlı HTTP yanıt
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneral(Exception ex) {
        return ResponseEntity.internalServerError().body("Unexpected error: " + ex.getMessage());
    }
}
