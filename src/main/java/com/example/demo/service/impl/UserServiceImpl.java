package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository repo = new UserRepository();

    public User createUser(User u) { return repo.save(u); }
    public User getUserById(Long id) { return repo.findById(id); }
    public List<User> getAllUsers() { return repo.findAll(); }
    public User updateUser(Long id, User u) { return repo.update(id, u); }
    public void deleteUser(Long id) { repo.deleteById(id); }
}
