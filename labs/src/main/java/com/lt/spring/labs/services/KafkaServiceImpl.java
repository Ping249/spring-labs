package com.lt.spring.labs.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lt.spring.labs.dto.messaging.OrderRequestedMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService {

    private final KafkaTemplate<String, String> template;
    ObjectMapper objectMapper;

    public KafkaServiceImpl(KafkaTemplate<String, String> template) {
        this.template = template;
        this.objectMapper = new ObjectMapper();
    }
    @Override
    public void sendOrder(OrderRequestedMessage order) {
        try {
            String body = objectMapper.writeValueAsString(order);
            template.send("orders", body);
        } catch (Exception e) {
            System.out.println("ERROR DURING SERIALIZATION");
        }
    }
}