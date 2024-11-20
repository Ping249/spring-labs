package com.lt.spring.labs.services;

import com.lt.spring.labs.entities.Portfolio;

public interface PortfolioService {
    Portfolio getPortfolio(Long id);
    Iterable<Portfolio> getPortfolios();
    Portfolio addPortfolio(Portfolio portfolio);
    Iterable<Portfolio> getPortfoliosByUserId(Long id);
}
