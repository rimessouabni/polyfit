package com.polyfit.polyfit.services;

import java.util.List;

import com.polyfit.polyfit.model.User;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}