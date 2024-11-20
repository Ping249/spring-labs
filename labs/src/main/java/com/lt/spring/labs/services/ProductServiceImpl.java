package com.lt.spring.labs.services;

import com.lt.spring.labs.Repo.StockRepository;
import com.lt.spring.labs.dto.GetProductDetailsDTO;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements  ProductService{
    private final StockRepository repoStock;
    public ProductServiceImpl( StockRepository repoStock) {
        this.repoStock = repoStock;
    }
    @Override
    public Iterable<GetProductDetailsDTO> getProducts() {
        return StreamSupport.stream( repoStock.findAll().spliterator(),false)
                .map(s-> new GetProductDetailsDTO(s.getId(), s.getSymbol(), s.getMinOrder(), s.getMaxOrder()))
                .collect(Collectors.toList());

    }
}