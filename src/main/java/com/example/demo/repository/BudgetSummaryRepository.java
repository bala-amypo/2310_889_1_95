package com.example.demo.repository;

import com.example.demo.model.BudgetSummary;
import java.util.*;

public class BudgetSummaryRepository {
    private final Map<Long, BudgetSummary> store = new HashMap<>();

    public BudgetSummary save(BudgetSummary b) { store.put(b.getId(), b); return b; }
    public BudgetSummary findById(Long id) { return store.get(id); }
    public List<BudgetSummary> findAll() { return new ArrayList<>(store.values()); }
    public BudgetSummary update(Long id, BudgetSummary b) { store.put(id, b); return b; }
    public void deleteById(Long id) { store.remove(id); }
}
