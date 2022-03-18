package be.fedei91.todoapp.services;

import be.fedei91.todoapp.domain.User;

import java.util.List;

public interface UserService {
    void create(User user);
    List<User> findAll();
    User findUserByEmail(String email);
}
