package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo = new UserRepository();

    public User create(User u) { return repo.save(u); }
    public User get(Long id) { return repo.findById(id); }
    public List<User> getAll() { return repo.findAll(); }
    public User update(Long id, User u) { return repo.save(u); }
    public void delete(Long id) { repo.delete(id); }
}
