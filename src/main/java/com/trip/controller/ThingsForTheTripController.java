package com.trip.controller;

import com.trip.model.User;
import com.trip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller     // @Controller указывает, что данный класс играет роль контроллера.
public class ThingsForTheTripController {

    private UserService userService;

    @Autowired
    public void ControllerShoppingList(UserService us) {
        this.userService = us;

    }


    @GetMapping(value = "/")
    public ModelAndView homePage() {
        System.out.println("ModelAndView homePage");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start-page");
        return modelAndView;
    }

    @GetMapping(value = "/register")
    public ModelAndView registerUser() {
        System.out.println("ModelAndView registerUser");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping(value = "/addUser")
    public ModelAndView addUser(@ModelAttribute("userJSP") User user) {
        System.out.println("ModelAndView addUser");
        ModelAndView modelAndView = new ModelAndView();
        userService.add(user);
        modelAndView.setViewName("result");
        modelAndView.addObject("userJSP", user);
        return modelAndView;
    }

}
