package com.lt.spring.labs.configuration;

import com.lt.spring.labs.exceptions.utils.ErrorBuilder;
import com.lt.spring.labs.exceptions.web.ErrorBody;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<ErrorBody> handleValidationException(MethodArgumentNotValidException e) {
        ErrorBody body = ErrorBuilder.buildValidationErrorResponse(e);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(body);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<ErrorBody> handleValidationException(ConstraintViolationException e) {
        ErrorBody body = ErrorBuilder.buildValidationErrorResponse(e);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(body);
    }
}
