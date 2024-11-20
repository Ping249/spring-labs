package com.lt.spring.labs.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="portfolios")
public class Portfolio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Portfolio() {
    }

    public Portfolio(Long id, String name, Long userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

}