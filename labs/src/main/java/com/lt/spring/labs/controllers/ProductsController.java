package com.lt.spring.labs.controllers;

import com.lt.spring.labs.dto.GetProductDetailsDTO;
import com.lt.spring.labs.dto.GetProductPriceDTO;
import com.lt.spring.labs.exceptions.core.ItemNotFoundException;
import com.lt.spring.labs.exceptions.utils.PlatformExceptions;
import com.lt.spring.labs.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductsController {
    private final ProductService prodSvc;
    public ProductsController(ProductService prodSvc) {
        this.prodSvc = prodSvc;
    }
    @GetMapping
    public Iterable<GetProductDetailsDTO>getProducts() {
        return prodSvc.getProducts();
    }

    @GetMapping("{symb}/price")
    public GetProductPriceDTO getProductPrice(@PathVariable String symb) {
        try {
            return prodSvc.getProductPrice(symb);
        } catch (ItemNotFoundException e) {
            throw PlatformExceptions.returnNotFound(e);
        }
    }
}