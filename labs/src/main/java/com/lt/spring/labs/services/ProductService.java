package com.lt.spring.labs.services;

import com.lt.spring.labs.dto.GetProductDetailsDTO;

import java.util.List;

public interface ProductService {
    List<GetProductDetailsDTO> getProducts();
}