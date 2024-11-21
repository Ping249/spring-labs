package com.lt.spring.labs.exceptions;

public class ForbiddenAccountActionException extends RuntimeException {
    public ForbiddenAccountActionException(String message) {
        super(message);
    }
}