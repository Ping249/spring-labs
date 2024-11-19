package com.lt.spring.labs;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MessageGenerator {
    public String getMessage() {
        if(LocalDateTime.now().getHour() < 12) {
            return "Good morning";
        }
        return "Good afternoon";
    }

}
