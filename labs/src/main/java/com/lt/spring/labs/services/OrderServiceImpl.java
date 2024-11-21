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
import com.lt.spring.labs.exceptions.ItemNotFoundException;
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
        Optional<User> opUser = repoUser.findById(request.getUserId());
        Optional<Stock> opStock = repoStock.findBySymbol(request.getSymbol());
        if(opUser.isEmpty()) {
            throw new ItemNotFoundException("User not found");
        }
        if(opStock.isEmpty()) {
            throw new ItemNotFoundException("Stock not found");
        }
        Order order = new Order(0L, opUser.get().getId(), opStock.get(),
                request.getQuantity(), Instant.now(),
                request.getSide(), Status.REQUESTED);
        repoOrder.save(order);
        return modelMapper.map(order, GetOrderDTO.class);
    }

}