package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role = "USER";

    public User() {}

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
