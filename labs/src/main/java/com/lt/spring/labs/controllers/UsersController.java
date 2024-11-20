package com.lt.spring.labs.controllers;

import com.lt.spring.labs.Repo.PortfolioRepository;
import com.lt.spring.labs.Repo.UserRepository;
import com.lt.spring.labs.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("users")
public class UsersController {
    private final UserRepository userRepo;
    private final PortfolioRepository portRepo;
    public UsersController(UserRepository userRepo,  PortfolioRepository portRepo) {
        this.userRepo = userRepo;
        this.portRepo = portRepo;
    }
    @PostMapping("{firstName}/{lastName}")
    @ResponseBody
    public void addUser(@PathVariable String firstName, @PathVariable String lastName)
    {
        userRepo.save(new User(0L, firstName, lastName));
    }
    @GetMapping("/")
    @ResponseBody
    public Iterable<User> getUsers()
    {
        return  userRepo.findAll();
    }
    @GetMapping("{id}")
    @ResponseBody
    public User getUser(@PathVariable Long id)
    {
        return userRepo.findById(id).get();
    }
}
