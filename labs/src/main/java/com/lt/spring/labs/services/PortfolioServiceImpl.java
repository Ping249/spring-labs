package com.lt.spring.labs.services;

import com.lt.spring.labs.Repo.PortfolioRepository;
import com.lt.spring.labs.entities.Portfolio;
import org.springframework.stereotype.Service;

@Service
public class PortfolioServiceImpl implements PortfolioService{
    private PortfolioRepository portRepo;
    public PortfolioServiceImpl(PortfolioRepository portRepo) {
        this.portRepo = portRepo;
    }

    @Override
    public Portfolio getPortfolio(Long id) {
        return portRepo.findById(id).get();
    }

    @Override
    public Iterable<Portfolio> getPortfolios() {
        return portRepo.findAll();
    }

    @Override
    public Portfolio addPortfolio(Portfolio portfolio) {
        return portRepo.save(portfolio);
    }

    @Override
    public Iterable<Portfolio> getPortfoliosByUserId(Long id) {
        return portRepo.findAllByUserId(id);
    }
}
