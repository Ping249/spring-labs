package com.lt.spring.labs.services;

import com.lt.spring.labs.dto.GetProductDetailsDTO;
import com.lt.spring.labs.dto.GetProductPriceDTO;

import java.util.List;

public interface ProductService {
    List<GetProductDetailsDTO> getProducts();
    GetProductPriceDTO getProductPrice(String symbol);

}