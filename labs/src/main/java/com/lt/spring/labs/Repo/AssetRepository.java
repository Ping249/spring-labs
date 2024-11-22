package com.lt.spring.labs.Repo;

import com.lt.spring.labs.entities.Asset;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssetRepository extends CrudRepository<Asset, Long> {
    List<Asset> findByPortfolioIdEquals(Long portfolioId);
}