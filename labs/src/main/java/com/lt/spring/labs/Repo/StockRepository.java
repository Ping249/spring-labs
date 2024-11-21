package com.lt.spring.labs.Repo;

import com.lt.spring.labs.entities.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
    Optional<Stock> findBySymbol(String symbol);
}