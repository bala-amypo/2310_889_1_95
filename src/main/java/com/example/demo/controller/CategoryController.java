package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/categories")
@Tag(name = "Category APIs")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @Operation(summary = "Create category")
    @PostMapping
    public Category create(@RequestBody Category category) {
        return service.create(category);
    }

    @Operation(summary = "Get all categories")
    @GetMapping
    public List<Category> getAll() {
        return service.getAll();
    }
}
