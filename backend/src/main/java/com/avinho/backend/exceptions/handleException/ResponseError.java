package com.avinho.backend.exceptions.handleException;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ResponseError {
    private String status = "error";
    private Date timestamp = new Date();
    private int statusCode = 400;
    private String error;
}
