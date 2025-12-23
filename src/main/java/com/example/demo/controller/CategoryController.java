package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import com.example.demo.service.impl.CategoryServiceImpl;

public class CategoryController {
    public static void main(String[] args) {
        CategoryService service = new CategoryServiceImpl();

        service.createCategory(new Category(1L, "Food", "EXPENSE"));
        System.out.println(service.getCategoryById(1L).getName());

        service.updateCategory(1L, new Category(1L, "Groceries", "EXPENSE"));
        service.getAllCategories().forEach(c -> System.out.println(c.getName()));

        service.deleteCategory(1L);
    }
}
