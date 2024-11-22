package com.lt.spring.labs.controllers;

import com.lt.spring.labs.Repo.PortfolioRepository;
import com.lt.spring.labs.dto.GetPortfolioDTO;
import com.lt.spring.labs.entities.Portfolio;
import com.lt.spring.labs.exceptions.core.ItemNotFoundException;
import com.lt.spring.labs.exceptions.utils.PlatformExceptions;
import com.lt.spring.labs.services.PortfolioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("portfolios")
public class PortfoliosController {
    private final PortfolioService portSvc;

    public PortfoliosController(PortfolioService portSvc) {
        this.portSvc = portSvc;
    }

    @PostMapping("{name}/{userId}")
    public GetPortfolioDTO createPortfolio(@PathVariable String name, @PathVariable Long userId) {
        GetPortfolioDTO portfolio = portSvc.addPortfolio(new Portfolio(0L, name, userId));
        //return ResponseEntity.ok(null);
        return portfolio;
    }

    @GetMapping("")
    public Iterable<Portfolio> getPortfolios() {
        return portSvc.getPortfolios();
    }




    @GetMapping("{id}")
    public GetPortfolioDTO getPortfolio(@PathVariable Long id) {
        try {
            return portSvc.getPortfolio(id);
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
            throw PlatformExceptions.returnNotFound(e);
        }
    }

}
