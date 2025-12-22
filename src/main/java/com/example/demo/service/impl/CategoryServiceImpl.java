package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repo = new CategoryRepository();

    public Category createCategory(Category c) { return repo.save(c); }
    public Category getCategoryById(Long id) { return repo.findById(id); }
    public List<Category> getAllCategories() { return repo.findAll(); }
    public Category updateCategory(Long id, Category c) { return repo.update(id, c); }
    public void deleteCategory(Long id) { repo.deleteById(id); }
}
