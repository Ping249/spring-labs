package com.lt.spring.labs.dto;

import com.lt.spring.labs.entities.Side;
import com.lt.spring.labs.entities.Stock;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderDTO {
    private Long id;
    private Long userId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;
    private Integer quantity;
    private Instant timestamp = Instant.now();
    private Side side;
}