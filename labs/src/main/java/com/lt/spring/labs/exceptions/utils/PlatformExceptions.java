package com.lt.spring.labs.exceptions.utils;

import com.lt.spring.labs.exceptions.web.BadRequestResponseException;
import com.lt.spring.labs.exceptions.web.ItemNotFoundResponseException;

public class PlatformExceptions {
    public static BadRequestResponseException returnBadRequest(Exception e) {
        return new BadRequestResponseException(e);
    }
    public static ItemNotFoundResponseException returnNotFound(Exception e) {
        return new ItemNotFoundResponseException(e);
    }
}