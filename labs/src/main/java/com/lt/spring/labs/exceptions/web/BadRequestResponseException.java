package com.lt.spring.labs.exceptions.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestResponseException extends  RuntimeException {
    public BadRequestResponseException(Exception e) {
        super(e);
    }
}