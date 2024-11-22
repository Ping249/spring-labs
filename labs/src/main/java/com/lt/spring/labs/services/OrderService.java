package com.lt.spring.labs.services;

import com.lt.spring.labs.dto.GetOrderDTO;
import com.lt.spring.labs.dto.PlaceOrderDTO;

public interface OrderService {

    public GetOrderDTO placeOrder(PlaceOrderDTO request);
}