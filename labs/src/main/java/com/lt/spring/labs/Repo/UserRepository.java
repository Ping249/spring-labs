package com.lt.spring.labs.Repo;

import com.lt.spring.labs.entities.Portfolio;
import com.lt.spring.labs.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
//    void addUser(String firstName, String LastName);
//
//    User getUser(Long id);
//
//    Iterable<User> getUsers();
//
//    Iterable<Portfolio> findAllByUserId(Long userId);
}