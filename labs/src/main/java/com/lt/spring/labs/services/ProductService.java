package com.lt.spring.labs.services;

import com.lt.spring.labs.dto.GetProductDetailsDTO;

public interface ProductService {
    Iterable<GetProductDetailsDTO> getProducts();
}