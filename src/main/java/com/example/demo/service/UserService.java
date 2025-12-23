package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;

public interface UserService {
    User create(User u);
    User get(Long id);
    List<User> getAll();
    User update(Long id, User u);
    void delete(Long id);
}
