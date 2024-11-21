package com.lt.spring.labs.services;

import com.lt.spring.labs.Repo.StockRepository;
import com.lt.spring.labs.configuration.MyMapper;
import com.lt.spring.labs.dto.GetProductDetailsDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements  ProductService{
    private final StockRepository repoStock;
    private final MyMapper mapper;
    public ProductServiceImpl( StockRepository repoStock, MyMapper mapper) {
        this.mapper = mapper;
        this.repoStock = repoStock;
    }

    @Override
    public List<GetProductDetailsDTO> getProducts() {
        return StreamSupport.stream( repoStock.findAll().spliterator(),false)
                .map(s -> mapper.map(s, GetProductDetailsDTO.class))
                .collect(Collectors.toList());
    }
}