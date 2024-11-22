package com.lt.spring.labs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetProductPriceDTO {
    private String symbol;
    private Long price;
}