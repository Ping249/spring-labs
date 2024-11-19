package com.lt.spring.labs.Repo;


import com.lt.spring.labs.entities.Portfolio;

public interface PortfolioRepository {
    void addPortfolio(String name, Long userId);
    Portfolio getPortfolio(Long id);
    Iterable<Portfolio> getPortfolios();
}
