package com.lt.spring.labs.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetProductDetailsDTO {
    private Long id;
    private String symbol;
    private Integer minOrder;
    private Integer maxOrder;
}
