package com.lt.spring.labs.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAssetDTO {
    private Long id;
    private Long portfolioId;
    private Long productId;
    private Integer quantity;
    private Long price;
}