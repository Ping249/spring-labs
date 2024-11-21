package com.lt.spring.labs.services;

import com.lt.spring.labs.Repo.OrderRepository;
import com.lt.spring.labs.Repo.StockRepository;
import com.lt.spring.labs.Repo.UserRepository;
import com.lt.spring.labs.dto.GetOrderDTO;
import com.lt.spring.labs.dto.PlaceOrderDTO;
import com.lt.spring.labs.entities.Order;
import com.lt.spring.labs.entities.Status;
import com.lt.spring.labs.entities.Stock;
import com.lt.spring.labs.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{
    private UserRepository repoUser;
    private StockRepository repoStock;
    private OrderRepository repoOrder;
    private ModelMapper modelMapper;

    public OrderServiceImpl(UserRepository repoUser, StockRepository repoStock, OrderRepository repoOrder, ModelMapper modelMapper) {
        this.repoUser = repoUser;
        this.repoStock = repoStock;
        this.repoOrder = repoOrder;
        this.modelMapper = modelMapper;
    }

    @Override
    public GetOrderDTO placeOrder(PlaceOrderDTO request) {
        User u = repoUser.findById(request.getUserId()).get();
        Stock s = repoStock.findBySymbol(request.getSymbol()).get();
        Order o = new Order(0L, request.getUserId(), s,
                request.getQuantity(), Instant.now(), request.getSide(), Status.PLACED);
        repoOrder.save(o);
        GetOrderDTO dtoOrder = modelMapper.map(o, GetOrderDTO.class);
        return dtoOrder;
    }
}