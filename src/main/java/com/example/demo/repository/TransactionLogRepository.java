package com.example.demo.repository;

import com.example.demo.model.TransactionLog;
import java.util.*;

public class TransactionLogRepository {
    private final Map<Long, TransactionLog> store = new HashMap<>();

    public TransactionLog save(TransactionLog t) { store.put(t.getId(), t); return t; }
    public TransactionLog findById(Long id) { return store.get(id); }
    public List<TransactionLog> findAll() { return new ArrayList<>(store.values()); }
    public TransactionLog update(Long id, TransactionLog t) { store.put(id, t); return t; }
    public void deleteById(Long id) { store.remove(id); }
}
