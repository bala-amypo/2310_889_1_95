package com.example.demo.repository;

import com.example.demo.model.User;
import java.util.*;

public class UserRepository {
    private final Map<Long, User> store = new HashMap<>();

    public User save(User u) { store.put(u.getId(), u); return u; }
    public User findById(Long id) { return store.get(id); }
    public List<User> findAll() { return new ArrayList<>(store.values()); }
    public void delete(Long id) { store.remove(id); }
}
