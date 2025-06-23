package com.begumneval.vetmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    // Değerlendirme formu 26: Exception kullanımı
    public NotFoundException(String message) {
        super(message);
    }
}
