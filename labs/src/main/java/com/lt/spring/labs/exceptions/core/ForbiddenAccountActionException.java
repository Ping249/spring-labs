package com.lt.spring.labs.exceptions.core;

public class ForbiddenAccountActionException extends RuntimeException {
    public ForbiddenAccountActionException(String message) {
        super(message);
    }
}