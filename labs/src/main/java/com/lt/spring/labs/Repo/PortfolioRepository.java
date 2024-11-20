package com.lt.spring.labs.Repo;


import com.lt.spring.labs.entities.Portfolio;
import com.lt.spring.labs.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends CrudRepository<Portfolio, Long> {
//    void addPortfolio(String name, Long userId);
//    Portfolio getPortfolio(Long id);
//    Iterable<Portfolio> getPortfolios();
}
