package be.fedei91.todoapp.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddItemForm {
    @NotNull
    @NotEmpty
    private String description;

    public AddItemForm(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
