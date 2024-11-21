package com.lt.spring.labs.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TradedStockValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
public @interface TradedStock {
    String message() default "${validatedValue} is not a traded product";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}