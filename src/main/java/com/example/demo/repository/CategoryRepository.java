package com.example.demo.repository;

import com.example.demo.model.Category;
import java.util.*;

public class CategoryRepository {
    private final Map<Long, Category> store = new HashMap<>();

    public Category save(Category c) { store.put(c.getId(), c); return c; }
    public Category findById(Long id) { return store.get(id); }
    public List<Category> findAll() { return new ArrayList<>(store.values()); }
    public Category update(Long id, Category c) { store.put(id, c); return c; }
    public void deleteById(Long id) { store.remove(id); }
}
