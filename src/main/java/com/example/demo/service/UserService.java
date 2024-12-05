package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserByEmail(String email);
    User getUserById(Long id);
    void deleteUser(Long id);
}
