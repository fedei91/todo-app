package be.fedei91.todoapp.repositories;

import be.fedei91.todoapp.domain.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TodosRepository extends JpaRepository<TodoItem, Long> {
    List<TodoItem> findAllByUserEmail(String email);
    void deleteById(long id);
    @Query("select i from TodoItem i where i.id in(:ids)")
    List<TodoItem> findItemsByIds(Set<Long> ids);
}
