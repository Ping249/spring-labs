package com.lt.spring.labs.exceptions.utils;

import com.lt.spring.labs.exceptions.web.ErrorBody;
import com.lt.spring.labs.exceptions.web.ValidationError;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ErrorBuilder {
    public static ErrorBody buildValidationErrorResponse(MethodArgumentNotValidException e) {
        ErrorBody body = new ErrorBody();
        e.getBindingResult()
                .getAllErrors()
                .forEach((error) -> {
                    String fieldName;
                    try {
                        fieldName = ((FieldError) error)
                                .getField();
                    } catch (ClassCastException ex) {
                        fieldName = error.getObjectName();
                    }
                    String message = error.getDefaultMessage();
                    body.getValidationErrors()
                            .add(new ValidationError(
                                    fieldName, message));
                });
        body.setStatus(e.getStatusCode());
        return body;

    }

    public static ErrorBody buildValidationErrorResponse(ConstraintViolationException e) {
        ErrorBody body = new ErrorBody();
        e.getConstraintViolations().forEach(v -> {
            body.getValidationErrors().add(new ValidationError(
                    v.getPropertyPath().toString(),
                    v.getMessage()
            ));
        });
        body.setStatus(HttpStatus.BAD_REQUEST);
        return body;
    }
}