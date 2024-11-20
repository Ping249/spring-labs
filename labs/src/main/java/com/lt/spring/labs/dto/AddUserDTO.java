package com.lt.spring.labs.dto;

import com.lt.spring.labs.entities.IdentifierType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserDTO {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String emailAddress;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String countryOfResidence;
    @NotEmpty
    private String governmentIdentifier;
    private IdentifierType identifierType;
}
