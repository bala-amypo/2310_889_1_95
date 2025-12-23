package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User API", description = "CRUD operations for User")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create User")
    public User create(@RequestBody User u) {
        return service.create(u);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get User by ID")
    public User get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    @Operation(summary = "Get All Users")
    public List<User> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update User")
    public User update(@PathVariable Long id, @RequestBody User u) {
        return service.update(id, u);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete User")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
