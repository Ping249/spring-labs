package com.lt.spring.labs.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapWrapper {
    @Bean
    public MyMapper getMapper() {
        return new MyMapper();
    }
}