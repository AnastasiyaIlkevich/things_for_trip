package com.trip.controller;

import com.trip.model.User;
import com.trip.service.UserService;
import com.trip.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void ControllerShoppingList(UserService us) {
        this.userService = us;
    }

    @GetMapping(value = "/")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start-page");
        log.debug("Start of the program");
        return modelAndView;
    }

    @GetMapping(value = "/register")
    public ModelAndView registerUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("register");
        log.debug("User registration");
        return modelAndView;
    }

    @PostMapping(value = "/addUser")
    public ModelAndView addUser(@ModelAttribute("userJSP") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return registerUser();
        }
        log.debug("adding user", user);
        userService.add(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("userJSP", user);
        return modelAndView;
    }

    @GetMapping(value ="/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("mass", "Введите пороль и логин");
        modelAndView.addObject("userJSP", new User());
        return modelAndView;
    }

    @PostMapping(value ="/loginUser")
    public ModelAndView loginUser(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", user);
        User userDataBase  = userService.getByName(user.getName());
        if (userDataBase != null){

            if (passwordEncoder.matches(user.getPassword(),userDataBase.getPassword())){
                modelAndView.setViewName("welcome");
                log.debug("пороль введен правильно");
                return modelAndView;
            } else {
                log.debug("пороль введен не правильно");
            }
        }
        modelAndView.setViewName("login");
        modelAndView.addObject("mass", "имя или пороль введены не верно");
        return modelAndView;
    }

    @GetMapping(value ="/admin")
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        modelAndView.addObject("mass", "Тута живет админ");
        return modelAndView;
    }
}
