package com.lt.spring.labs.controllers;

import com.lt.spring.labs.Repo.UserRepository;
import com.lt.spring.labs.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("users")
public class UsersController {
    private final UserRepository userRepo;
    public UsersController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    @PostMapping("{firstName}/{lastName}")
    @ResponseBody
    public void addUser(@PathVariable String firstName, @PathVariable String lastName)
    {
        userRepo.addUser(firstName, lastName);
    }
    @GetMapping("")
    @ResponseBody
    public Iterable<User> getUsers()
    {
        return userRepo.getUsers();
    }
    @GetMapping("{id}")
    @ResponseBody
    public User getUser(@PathVariable Long id)
    {
        return userRepo.getUser(id);
    }
}
