package com.lt.spring.labs.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "userId")
    private List<Portfolio> portfolios = new ArrayList<>();
    private String emailAddress;
    private String phoneNumber;
    private String countryOfResidence;
    private String governmentIdentifier;
    private Long balanceHeldOnAccount;
    private IdentifierType identifierType;
}