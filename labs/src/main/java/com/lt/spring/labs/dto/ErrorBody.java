package com.lt.spring.labs.dto;

import com.lt.spring.labs.exceptions.web.ValidationError;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ErrorBody {
    private HttpStatusCode status;
    private List<ValidationError> validationErrors = new ArrayList<>();
}