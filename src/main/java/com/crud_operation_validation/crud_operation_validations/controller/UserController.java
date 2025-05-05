package com.crud_operation_validation.crud_operation_validations.controller;


import com.crud_operation_validation.crud_operation_validations.model.User;
import com.crud_operation_validation.crud_operation_validations.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public String createUser(@Valid @RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String filter
    ) {
        return service.getAllUsers(sortBy, filter);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @Valid @RequestBody User user) {
        user.setId(id);
        return service.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
}
