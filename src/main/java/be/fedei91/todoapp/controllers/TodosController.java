package be.fedei91.todoapp.controllers;

import be.fedei91.todoapp.services.TodosService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("todos")
class TodosController {
    private final TodosService todosService;

    TodosController(TodosService todosService) {
        this.todosService = todosService;
    }

    @GetMapping
    public ModelAndView showTodosFromUser(Principal principal) {
        var modelAnView = new ModelAndView("todos");
        modelAnView.addObject("todos", todosService.findAllByUserEmail(principal.getName()));
        return modelAnView;
    }
}
