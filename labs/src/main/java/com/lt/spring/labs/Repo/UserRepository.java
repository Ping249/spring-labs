package com.lt.spring.labs.Repo;

import com.lt.spring.labs.entities.User;

public interface UserRepository {
    void addUser(String firstName, String LastName);

    User getUser(Long id);

    Iterable<User> getUsers();
}