package com.lt.spring.labs.exceptions.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ValidationError {
    private String field;
    private String message;
}