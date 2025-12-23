package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private String type;

    public Category() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
