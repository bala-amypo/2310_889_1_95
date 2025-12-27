package com.example.demo.model;
import com.example.demo.exception.BadRequestException;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Data @NoArgsConstructor @AllArgsConstructor
public class Category {
    public static final String TYPE_INCOME = "INCOME";
    public static final String TYPE_EXPENSE = "EXPENSE";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String type;

    public void validateType() {
        if (!TYPE_INCOME.equals(type) && !TYPE_EXPENSE.equals(type)) {
            throw new BadRequestException("Invalid category type");
        }
    }
}