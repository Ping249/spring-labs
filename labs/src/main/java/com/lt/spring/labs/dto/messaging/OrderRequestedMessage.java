package com.lt.spring.labs.dto.messaging;

import com.lt.spring.labs.entities.Side;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestedMessage {
    private Long id;
    private String symbol;
    private Integer quantity;
    private Side side;
}