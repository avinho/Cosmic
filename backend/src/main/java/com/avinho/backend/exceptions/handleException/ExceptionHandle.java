package com.avinho.backend.exceptions.handleException;

import com.avinho.backend.exceptions.ResourceAlreadyExistsException;
import com.avinho.backend.exceptions.ResourceNotFoundException;
import jakarta.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.UndeclaredThrowableException;

@RestControllerAdvice
public class ExceptionHandle extends ResponseEntityExceptionHandler {
    @Resource
    private MessageSource messageSource;
    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private ResponseError responseError(String message, HttpStatus statusCode) {
        ResponseError error = new ResponseError();
        error.setStatus("error");
        error.setError(message);
        error.setStatusCode(statusCode.value());
        return error;
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> handleGeneral(Exception e, WebRequest request) {
        if (e.getClass().isAssignableFrom(UndeclaredThrowableException.class)) {
            UndeclaredThrowableException exception = (UndeclaredThrowableException) e;
            return handleGenericException((GenericException) exception.getUndeclaredThrowable(), request);
        } else {
            String message = messageSource.getMessage("error.server", new Object[]{e.getMessage()}, null);
            ResponseError error = responseError(message,HttpStatus.INTERNAL_SERVER_ERROR);
            return handleExceptionInternal(e, error, headers(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        }
    }

    @ExceptionHandler({GenericException.class})
    private ResponseEntity<Object> handleGenericException(GenericException e, WebRequest request) {
        ResponseError error = responseError(e.getMessage(),HttpStatus.CONFLICT);
        return handleExceptionInternal(e, error, headers(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    private ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
        ResponseError error = responseError(e.getMessage(),HttpStatus.NOT_FOUND);
        return handleExceptionInternal(e, error, headers(), HttpStatus.NOT_FOUND, request);
    }
    @ExceptionHandler({ResourceAlreadyExistsException.class})
    private ResponseEntity<Object> handleResourceAlReadyExistsException(ResourceAlreadyExistsException e, WebRequest request) {
        ResponseError error = responseError(e.getMessage(),HttpStatus.CONFLICT);
        return handleExceptionInternal(e, error, headers(), HttpStatus.CONFLICT, request);
    }
}
