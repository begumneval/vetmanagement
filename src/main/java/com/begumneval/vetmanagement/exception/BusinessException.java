package com.begumneval.vetmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessException extends RuntimeException {
    // Değerlendirme formu 26: Exception kullanımı
    public BusinessException(String message) {
        super(message);
    }
}
