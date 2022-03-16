package be.fedei91.todoapp.controllers;

import be.fedei91.todoapp.domain.User;
import be.fedei91.todoapp.forms.RegisterForm;
import be.fedei91.todoapp.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("users")
class UserController {
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView showUsers() {
        var modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }

    @GetMapping("register/form")
    public ModelAndView formRegister() {
        var modelAndView = new ModelAndView("register");
        modelAndView.addObject(new RegisterForm(null, null));
        return modelAndView;
    }

    @PostMapping("register")
    public ModelAndView userRegister(@Valid RegisterForm form, Errors errors) {
        var modelAndView = new ModelAndView("login");
        var userEmailToRegister = form.getEmail();
        var originalPassword = form.getPassword();

        var encryptedPassword = new BCryptPasswordEncoder().encode(originalPassword);

        var userExists = userService.findUserByEmail(userEmailToRegister);

        if (errors.hasErrors()) {
            return modelAndView;
        }

        if (userExists != null) {
            return modelAndView.addObject("existingUser", userExists);
        }

        userService.create(new User(userEmailToRegister, encryptedPassword));

        return modelAndView;
    }
}
