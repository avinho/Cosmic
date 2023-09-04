package com.avinho.backend.exceptions.handleException;

public class GenericException extends RuntimeException{
    public GenericException(String message) {
        super(message);
    }

    public GenericException(String message, Object... params) {
        super(String.format(message, params));
    }
}
