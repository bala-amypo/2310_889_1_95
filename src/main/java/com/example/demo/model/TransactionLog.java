package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class TransactionLog {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    private Double amount;
    private String description;
    private LocalDate transactionDate;

    public TransactionLog() {}
}
