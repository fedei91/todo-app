package be.fedei91.todoapp.controllers;

import be.fedei91.todoapp.domain.TodoItem;
import be.fedei91.todoapp.domain.User;
import be.fedei91.todoapp.forms.AddItemForm;
import be.fedei91.todoapp.forms.TodoItemForm;
import be.fedei91.todoapp.services.TodosService;
import be.fedei91.todoapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("todos")
class TodosController {
    private final TodosService todosService;
    private final UserService userService;

    TodosController(TodosService todosService, UserService userService) {
        this.todosService = todosService;
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView showTodosFromUser(Principal principal) {
        var modelAnView = new ModelAndView("todos");
        modelAnView.addObject("todos", todosService.findAllByUserEmail(principal.getName()));
        modelAnView.addObject("todoItemForm", new TodoItemForm(null));
        modelAnView.addObject("addItemForm", new AddItemForm(null));
        return modelAnView;
    }

    @PostMapping("/additem")
    public ModelAndView addItemToUser(Long id, @Valid AddItemForm form, Errors errors, Principal principal) {
        if (errors.hasErrors()) {
            return new ModelAndView("todos");
        }

        User user = userService.findUserByEmail(principal.getName());
        String newItemDescription = form.getDescription();
        TodoItem newItem = new TodoItem(newItemDescription, false, user);
        todosService.create(newItem);

        return new ModelAndView("redirect:/todos");
    }

    @PostMapping("/deleteitems")
    public ModelAndView delete(@Valid TodoItemForm form, Errors errors) {
        if (errors.hasErrors()) {
            return new ModelAndView("todos");
        }

        List<TodoItem> itemsToDelete =
                todosService.findItemsByIds(form.getSelectedTodoItemsIds());
        itemsToDelete
                .forEach(
                        item -> todosService.delete(item.getId())
                );
        return new ModelAndView("redirect:/todos");
    }
}
