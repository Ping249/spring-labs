package com.lt.spring.labs.services;

import com.lt.spring.labs.Repo.AssetRepository;
import com.lt.spring.labs.Repo.PortfolioRepository;
import com.lt.spring.labs.dto.GetAssetDTO;
import com.lt.spring.labs.dto.GetPortfolioDTO;
import com.lt.spring.labs.entities.Portfolio;
import com.lt.spring.labs.exceptions.core.ItemNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class PortfolioServiceImpl implements PortfolioService{
    private final ModelMapper modelMapper;
    private final AssetRepository assetRepository;
    private final PortfolioRepository portfolioRepository;

    public PortfolioServiceImpl(
            ModelMapper modelMapper,
            AssetRepository assetRepository,
            PortfolioRepository portfolioRepository){
        this.modelMapper = modelMapper;
        this.assetRepository = assetRepository;
        this.portfolioRepository = portfolioRepository;
    }


    @Override
    public GetPortfolioDTO getPortfolio(Long id) {
        Optional<Portfolio> byId = portfolioRepository.findById(id);
        if(byId.isEmpty()) {
            throw new ItemNotFoundException("No portfolio with the id " + id);
        }
        GetPortfolioDTO dto = modelMapper.map(byId.get(), GetPortfolioDTO.class);
        List<GetAssetDTO> assets = assetRepository.findByPortfolioIdEquals(dto.getId()).stream()
                .map(a -> modelMapper.map(a, GetAssetDTO.class)).toList();
        dto.setAssets(assets);

        return dto;
    }

    @Override
    public Iterable<Portfolio> getPortfolios() {
        return portfolioRepository.findAll();
    }

    @Override
    public GetPortfolioDTO addPortfolio(Portfolio portfolio) {
        Portfolio p = portfolioRepository.save(portfolio);
        GetPortfolioDTO map = modelMapper.map(p, GetPortfolioDTO.class);
        map.setAssets(new ArrayList<>());
        return map;
    }

    @Override
    public Iterable<GetPortfolioDTO> getPortfoliosByUserId(Long id) {
        Iterable<Portfolio> allByUserId = portfolioRepository.findAllByUserId(id);
        return StreamSupport.stream(allByUserId.spliterator(), false)
                .map(p -> {
                    GetPortfolioDTO map = modelMapper.map(p, GetPortfolioDTO.class);
                    List<GetAssetDTO> assets = assetRepository.findByPortfolioIdEquals(p.getId()).stream()
                            .map(a -> modelMapper.map(a, GetAssetDTO.class)).toList();
                    map.setAssets(assets);
                    return map;
                }).toList();
    }
}
