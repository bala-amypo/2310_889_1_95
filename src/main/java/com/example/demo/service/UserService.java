package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;

public interface UserService {
    User createUser(User u);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User u);
    void deleteUser(Long id);
}
