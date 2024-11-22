package com.lt.spring.labs.controllers;

import com.lt.spring.labs.Repo.PortfolioRepository;
import com.lt.spring.labs.Repo.UserRepository;
import com.lt.spring.labs.dto.*;
import com.lt.spring.labs.entities.Portfolio;
import com.lt.spring.labs.entities.User;
import com.lt.spring.labs.exceptions.core.ItemNotFoundException;
import com.lt.spring.labs.exceptions.utils.ErrorBuilder;
import com.lt.spring.labs.exceptions.utils.PlatformExceptions;
import com.lt.spring.labs.exceptions.web.ErrorBody;
import com.lt.spring.labs.services.PortfolioService;
import com.lt.spring.labs.services.UserService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("users")
public class UsersController {
    private final UserService userService;
    private final PortfolioService portService;

    public UsersController(UserService userService,  PortfolioService portService) {
        this.userService = userService;
        this.portService = portService;
    }

    @GetMapping
    public Iterable<GetUserProfileDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public GetUserProfileDTO getUser(@PathVariable Long id) {

        try {
            return userService.getUser(id);
        } catch (ItemNotFoundException e) {
            throw PlatformExceptions.returnNotFound(e);
        }
    }

    @PostMapping()
    public ResponseEntity<GetUserProfileDTO> createUser(@RequestBody @Valid AddUserDTO userData) {
        return ResponseEntity.ok(userService.addUser(userData));
    }


    @GetMapping("{id}/portfolios")
    public Iterable<GetPortfolioDTO> getUsersPortfolios(@PathVariable Long id) {
        try {
            return portService.getPortfoliosByUserId(id);
        } catch (ItemNotFoundException e) {
            throw PlatformExceptions.returnNotFound(e);
        }
    }

    @PatchMapping("{id}")
    public GetUserProfileDTO updateContactDetails(@PathVariable Long id, @RequestBody UpdateContactDetailsDTO details) {
        details.setId(id);
        try {
            return userService.updateContactDetails(details);
        } catch (Exception e) {
            throw PlatformExceptions.returnBadRequest(e);
        }
    }

    @GetMapping("{id}/balance")
    public GetBalanceDTO getBalance(@PathVariable Long id) {
        return userService.getBalanceOnAccount(id);
    }

    @GetMapping("{userId}/portfolios/{id}")
    public EntityModel<GetPortfolioDTO> getUsersPortfolio(@PathVariable Long userId, @PathVariable Long id) {
        try {
            List<GetPortfolioDTO> portfolios = StreamSupport.stream(portService.getPortfoliosByUserId(userId).spliterator(), false)
                    .sorted((a, b) -> a.getId().compareTo(b.getId()))
                    .toList();

            GetPortfolioDTO dto = portfolios.stream().filter(p -> p.getId().equals(id)).findFirst().get();
            int i = portfolios.indexOf(dto);
            EntityModel<GetPortfolioDTO> getPortfolioDtoEntityModel = EntityModel.of(dto);
            Link self = linkTo(UsersController.class).slash(userId).slash("portfolios").slash(id).withSelfRel();
            getPortfolioDtoEntityModel.add(self);
            Link collection = linkTo(UsersController.class).slash(userId).slash("portfolios").withRel(IanaLinkRelations.COLLECTION);
            getPortfolioDtoEntityModel.add(collection);
            if(i > 0){
                Link prev = linkTo(UsersController.class)
                        .slash(userId).slash("portfolios")
                        .slash(portfolios.get(i-1).getId())
                        .withRel(IanaLinkRelations.PREV);
                getPortfolioDtoEntityModel.add(prev);
            }
            if(i < portfolios.stream().count() - 1){
                Link next = linkTo(UsersController.class)
                        .slash(userId).slash("portfolios")
                        .slash(portfolios.get(i+1).getId())
                        .withRel(IanaLinkRelations.NEXT);
                getPortfolioDtoEntityModel.add(next);
            }
            return getPortfolioDtoEntityModel;
        } catch (ItemNotFoundException e) {
            throw PlatformExceptions.returnNotFound(e);
        }
    }


}
