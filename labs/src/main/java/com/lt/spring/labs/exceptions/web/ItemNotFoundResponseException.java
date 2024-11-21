package com.lt.spring.labs.exceptions.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundResponseException extends  RuntimeException {
    public ItemNotFoundResponseException(Exception e) {
        super(e);
    }
}