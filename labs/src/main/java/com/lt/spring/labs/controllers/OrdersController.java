package com.lt.spring.labs.controllers;

import com.lt.spring.labs.dto.PlaceOrderDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrdersController {
    @PostMapping
    public ResponseEntity placeOrder(@RequestBody @Valid PlaceOrderDto order) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }
}