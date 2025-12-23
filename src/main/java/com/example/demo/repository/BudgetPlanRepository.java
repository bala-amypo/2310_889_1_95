package com.example.demo.repository;

import com.example.demo.model.BudgetPlan;
import java.util.*;

public class BudgetPlanRepository {
    private final Map<Long, BudgetPlan> store = new HashMap<>();

    public BudgetPlan save(BudgetPlan b) { store.put(b.getId(), b); return b; }
    public BudgetPlan findById(Long id) { return store.get(id); }
    public List<BudgetPlan> findAll() { return new ArrayList<>(store.values()); }
    public BudgetPlan update(Long id, BudgetPlan b) { store.put(id, b); return b; }
    public void deleteById(Long id) { store.remove(id); }
}
