package com.lt.spring.labs.configuration;

import com.lt.spring.labs.dto.AddUserDTO;
import com.lt.spring.labs.dto.messaging.OrderRequestedMessage;
import com.lt.spring.labs.entities.Order;
import com.lt.spring.labs.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(AddUserDTO.class, User.class)
                .addMapping(src -> 0, User::setBalanceHeldOnAccount );
        mapper.typeMap(Order.class, OrderRequestedMessage.class)
                .addMapping(src -> src.getStock().getSymbol(), OrderRequestedMessage::setSymbol);
        return mapper;
    }
}