package com.example.simpleCRUD.service;

import com.example.simpleCRUD.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();

    Optional<User> getUser(long id);

    void addUser(User user);

    void deleteUser(long id);

    void updateUser(User user);
}
