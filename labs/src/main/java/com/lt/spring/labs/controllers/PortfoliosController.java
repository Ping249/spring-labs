package com.lt.spring.labs.controllers;

import com.lt.spring.labs.Repo.PortfolioRepository;
import com.lt.spring.labs.entities.Portfolio;
import com.lt.spring.labs.services.PortfolioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("portfolios")
public class PortfoliosController {
    private final PortfolioService portSvc;

    public PortfoliosController(PortfolioService portSvc) {
        this.portSvc = portSvc;
    }

    @PostMapping("{name}/{user_id}")
    public void addPortfolio(@PathVariable String name, @PathVariable Long user_id) {
        // portRepo.addPortfolio(name, user_id);
        portSvc.addPortfolio(new Portfolio(0L, name, user_id));
    }

    @GetMapping("")
    public Iterable<Portfolio> getPortfolios() {
        return portSvc.getPortfolios();
    }

    @GetMapping("{id}")
    public Portfolio getPortfolio(@PathVariable Long id) {
        return portSvc.getPortfolio(id);
    }

}
