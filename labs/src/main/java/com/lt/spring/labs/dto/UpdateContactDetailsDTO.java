package com.lt.spring.labs.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateContactDetailsDTO {
    @NotBlank
    private Long id;
    private String emailAddress;
    private String phoneNumber;
}