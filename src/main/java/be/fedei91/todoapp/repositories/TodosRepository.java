package be.fedei91.todoapp.repositories;

import be.fedei91.todoapp.domain.TodoItem;
import be.fedei91.todoapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodosRepository extends JpaRepository<TodoItem, Long> {
    List<TodoItem> findAllByUserEmail(String email);
}
