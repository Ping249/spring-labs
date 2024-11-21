package com.lt.spring.labs.dto;

import com.lt.spring.labs.constraints.TradedStock;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderDto {
    @Min(0)
    private Long userId;
    @NotBlank
    @TradedStock
    private String symbol;
    @Min(1)
    private Integer quantity;
}