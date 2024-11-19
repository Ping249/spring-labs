package com.lt.spring.labs.controllers;

import com.lt.spring.labs.Repo.PortfolioRepository;
import com.lt.spring.labs.entities.Portfolio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("portfolios")
public class PortfoliosController {
    private final PortfolioRepository portRepo;
    public PortfoliosController(PortfolioRepository portRepo) {
        this.portRepo = portRepo;
    }
    @PostMapping("{name}/{user_id}")
    @ResponseBody
    public void addPortfolio(@PathVariable String name, @PathVariable Long user_id)
    {
        portRepo.addPortfolio(name, user_id);
    }
    @GetMapping("")
    @ResponseBody
    public Iterable<Portfolio> getPortfolios()
    {
        return portRepo.getPortfolios();
    }
    @GetMapping("{id}")
    @ResponseBody
    public Portfolio getPortfolio(@PathVariable Long id)
    {
        return portRepo.getPortfolio(id);
    }

}
