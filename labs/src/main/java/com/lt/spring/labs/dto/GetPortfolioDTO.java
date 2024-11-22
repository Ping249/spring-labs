package com.lt.spring.labs.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetPortfolioDTO {
    private Long id;
    private String name;
    private List<GetAssetDTO> assets;
}