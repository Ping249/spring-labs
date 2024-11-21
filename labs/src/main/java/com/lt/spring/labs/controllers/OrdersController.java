package com.lt.spring.labs.controllers;

import com.lt.spring.labs.dto.GetOrderDTO;
import com.lt.spring.labs.dto.PlaceOrderDTO;
import com.lt.spring.labs.exceptions.utils.ErrorBuilder;
import com.lt.spring.labs.exceptions.utils.PlatformExceptions;
import com.lt.spring.labs.exceptions.web.ErrorBody;
import com.lt.spring.labs.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrdersController {
    private final OrderService svcOrder;
    public OrdersController(OrderService svcOrder) {
        this.svcOrder = svcOrder;
    }

    @PostMapping
    public GetOrderDTO placeOrder(@RequestBody @Valid PlaceOrderDTO orderRequest) {
        try {
            return svcOrder.placeOrder(orderRequest);
        } catch (Exception e) {
            throw PlatformExceptions.returnBadRequest(e);
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<ErrorBody> handleValidationException(MethodArgumentNotValidException e) {
        ErrorBody body = ErrorBuilder.buildValidationErrorResponse(e);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(body);
    }
}