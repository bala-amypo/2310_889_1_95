package com.example.demo.repository;

import com.example.demo.model.User;
import java.util.*;

public class UserRepository {
    private final Map<Long, User> store = new HashMap<>();

    public User save(User user) { store.put(user.getId(), user); return user; }
    public User findById(Long id) { return store.get(id); }
    public List<User> findAll() { return new ArrayList<>(store.values()); }
    public User update(Long id, User user) { store.put(id, user); return user; }
    public void deleteById(Long id) { store.remove(id); }
}
