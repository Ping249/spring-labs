package com.lt.spring.labs.controllers;

import com.lt.spring.labs.Repo.PortfolioRepository;
import com.lt.spring.labs.Repo.UserRepository;
import com.lt.spring.labs.dto.AddUserDTO;
import com.lt.spring.labs.dto.GetUserProfileDTO;
import com.lt.spring.labs.dto.UpdateContactDetailsDTO;
import com.lt.spring.labs.entities.Portfolio;
import com.lt.spring.labs.entities.User;
import com.lt.spring.labs.services.PortfolioService;
import com.lt.spring.labs.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UsersController {
    private final UserService userService;
    private final PortfolioService portService;

    public UsersController(UserService userService,  PortfolioService portService) {
        this.userService = userService;
        this.portService = portService;
    }

    @GetMapping("")
    public Iterable<GetUserProfileDTO> getUsers()
    {
        return userService.getUsers();
    }
    @GetMapping("{id}")
    public GetUserProfileDTO getUser(@PathVariable Long id)
    {
        return userService.getUser(id);
    }
    @PostMapping()
    public ResponseEntity<GetUserProfileDTO> createUser(@RequestBody @Valid AddUserDTO userData)
    {
        return ResponseEntity.ok(userService.addUser(userData));
    }


    @GetMapping("{id}/portfolios")
    public Iterable<Portfolio> getUserPortfolios(@PathVariable Long id)
    {
        return portService.getPortfoliosByUserId(id);
    }

    @PatchMapping("{id}")
    public GetUserProfileDTO updateContactDetails(@RequestBody @Valid UpdateContactDetailsDTO details) {
        return userService.updateContactDetails(details);
    }
}
