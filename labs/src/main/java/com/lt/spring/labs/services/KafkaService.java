package com.lt.spring.labs.services;

import com.lt.spring.labs.dto.messaging.OrderRequestedMessage;

public interface KafkaService {
    void sendOrder(OrderRequestedMessage order);
}