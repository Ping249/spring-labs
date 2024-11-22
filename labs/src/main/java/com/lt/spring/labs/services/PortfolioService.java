package com.lt.spring.labs.services;

import com.lt.spring.labs.dto.GetPortfolioDTO;
import com.lt.spring.labs.entities.Portfolio;

public interface PortfolioService {
    GetPortfolioDTO getPortfolio(Long id);
    Iterable<Portfolio> getPortfolios();
    GetPortfolioDTO addPortfolio(Portfolio portfolio);
    Iterable<GetPortfolioDTO> getPortfoliosByUserId(Long id);
}
