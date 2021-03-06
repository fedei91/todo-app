package be.fedei91.todoapp.controllers;

import be.fedei91.todoapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class IndexController {

    @GetMapping
    public String index() {
        return "index";
    }
}
