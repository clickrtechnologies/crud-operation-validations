package com.crud_operation_validation.crud_operation_validations.service;


import com.crud_operation_validation.crud_operation_validations.model.User;
import com.crud_operation_validation.crud_operation_validations.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public String createUser(User user) {
        if (repository.existsByEmailOrMobile(user.getEmail(), user.getMobileNumber())) {
            return "User with given email or mobile already exists.";
        }
        repository.save(user);
        return "User created successfully.";
    }

    public List<User> getAllUsers(String sortBy, String filter) {
        return repository.findAll(sortBy, filter);
    }

    public User getUserById(int id) {
        return repository.findById(id);
    }

    public String updateUser(User user) {
        repository.update(user);
        return "User updated successfully.";
    }

    public String deleteUser(int id) {
        repository.delete(id);
        return "User deleted successfully.";
    }
}
