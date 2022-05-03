package be.fedei91.todoapp.services;

import be.fedei91.todoapp.domain.TodoItem;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TodosService {
    List<TodoItem> findAllByUserEmail(String email);
    Optional<TodoItem> findTodoById(long id);
    TodoItem create(TodoItem item);
    void delete(long id);
    void update(Set<Long> ids);
    List<TodoItem> findItemsByIds(Set<Long> ids);
}
