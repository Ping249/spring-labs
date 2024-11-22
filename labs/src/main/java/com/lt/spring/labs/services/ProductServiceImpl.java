package com.lt.spring.labs.services;

import com.lt.spring.labs.Repo.StockRepository;
import com.lt.spring.labs.configuration.MyMapper;
import com.lt.spring.labs.dto.GetProductDetailsDTO;
import com.lt.spring.labs.dto.GetProductPriceDTO;
import com.lt.spring.labs.entities.Stock;
import com.lt.spring.labs.exceptions.core.ItemNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements  ProductService{
    private final StockRepository repoStock;
    private final ModelMapper mapper;
    public ProductServiceImpl( StockRepository repoStock, ModelMapper mapper) {
        this.mapper = mapper;
        this.repoStock = repoStock;
    }

    @Override
    public List<GetProductDetailsDTO> getProducts() {
        return StreamSupport.stream( repoStock.findAll().spliterator(),false)
                .map(s -> mapper.map(s, GetProductDetailsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetProductPriceDTO getProductPrice(String symbol) {
        Optional<Stock> bySymbol = repoStock.findBySymbol(symbol);
        if(bySymbol.isEmpty()) { throw new ItemNotFoundException("No product with symbol " + symbol); }
        return new GetProductPriceDTO(symbol, (long)(Math.random()*1000));
    }
}