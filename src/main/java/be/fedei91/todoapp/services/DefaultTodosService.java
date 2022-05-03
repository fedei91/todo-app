package be.fedei91.todoapp.services;

import be.fedei91.todoapp.domain.TodoItem;
import be.fedei91.todoapp.exceptions.TodosNotFoundException;
import be.fedei91.todoapp.repositories.TodosRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
class DefaultTodosService implements TodosService {
    private final TodosRepository todosRepository;

    DefaultTodosService(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    @Override
    public TodoItem create(TodoItem item) {
        return todosRepository.save(item);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TodoItem> findAllByUserEmail(String email) {
        return todosRepository.findAllByUserEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TodoItem> findTodoById(long id) {
        return todosRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        try {
            todosRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new TodosNotFoundException();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<TodoItem> findItemsByIds(Set<Long> ids) {
        return todosRepository.findItemsByIds(ids);
    }

    @Override
    public void update(Set<Long> ids) {
        List<TodoItem> itemsToUpdate =  todosRepository.findItemsByIds(ids);
        itemsToUpdate
                .forEach(
                        todoItem -> todoItem.setItemDone(!todoItem.getItemDone())
                );
    }
}
