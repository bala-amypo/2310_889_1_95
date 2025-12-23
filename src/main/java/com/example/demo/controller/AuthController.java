package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepo;

    public AuthController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginRequest) {

        Optional<User> userOpt =
                userRepo.findByEmail(loginRequest.getEmail());

        if (userOpt.isEmpty()) {
            return "User not found";
        }

        User user = userOpt.get();

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return "Invalid password";
        }

        return "Login successful";
    }
}
