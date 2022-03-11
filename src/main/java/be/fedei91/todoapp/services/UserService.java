package be.fedei91.todoapp.services;

import be.fedei91.todoapp.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void create(User user);
    List<User> findAll();
    User findUserByEmail(String email);
}
