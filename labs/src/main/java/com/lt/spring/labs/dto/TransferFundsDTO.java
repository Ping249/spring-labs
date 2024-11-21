package com.lt.spring.labs.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferFundsDTO {
    @Min(0)
    private Long userId;
    @Min(-500000)
    @Max(500000)
    private Long amount;
}