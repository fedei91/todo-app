package be.fedei91.todoapp.forms;

import java.util.Set;

public class TodoItemForm {
    private final Set<Long> selectedTodoItemsIds;

    public TodoItemForm(Set<Long> selectedTodoItemsIds) {
        this.selectedTodoItemsIds = selectedTodoItemsIds;
    }

    public Set<Long> getSelectedTodoItemsIds() {
        return selectedTodoItemsIds;
    }
}
