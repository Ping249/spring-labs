package com.lt.spring.labs.constraints;

import com.lt.spring.labs.dto.GetProductDetailsDTO;
import com.lt.spring.labs.services.ProductService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TradedStockValidator implements ConstraintValidator<TradedStock, String> {
    private final ProductService productService;
    private List<String> tradedProducts;
    public TradedStockValidator(ProductService productService){
        this.productService = productService;
        tradedProducts = new ArrayList<>();
    }

    @Override
    public void initialize(TradedStock constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        tradedProducts = productService.getProducts()
                .stream()
                .map(GetProductDetailsDTO::getSymbol)
                .collect(
                        Collectors.toList()
                );
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return tradedProducts.contains(s);
    }
}