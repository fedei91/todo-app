package be.fedei91.todoapp.services;

import be.fedei91.todoapp.domain.TodoItem;
import be.fedei91.todoapp.domain.User;

import java.util.List;
import java.util.Optional;

public interface TodosService {
    List<TodoItem> findAllByUserEmail(String email);
    Optional<TodoItem> findTodoById(long id);
    void create(TodoItem item);
    void delete(long id);
    void update(TodoItem item);
}
