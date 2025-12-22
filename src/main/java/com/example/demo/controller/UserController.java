package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;

public class UserController {
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();

        service.createUser(new User(1L, "Alice", "alice@gmail.com", "1234", "USER"));
        System.out.println(service.getUserById(1L).getName());

        service.updateUser(1L, new User(1L, "Alice Updated", "alice@gmail.com", "1234", "USER"));
        service.getAllUsers().forEach(u -> System.out.println(u.getName()));

        service.deleteUser(1L);
    }
}
