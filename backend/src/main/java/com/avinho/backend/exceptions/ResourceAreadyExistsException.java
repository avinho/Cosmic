package com.avinho.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceAreadyExistsException extends RuntimeException {
    public ResourceAreadyExistsException(String message) {
        super(message);
    }
}
