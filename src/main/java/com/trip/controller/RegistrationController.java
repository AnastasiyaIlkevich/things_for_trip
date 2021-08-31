package com.trip.controller;


import com.trip.model.User;
import com.trip.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private final UserServiceImpl userServiceImpl;

    public RegistrationController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userServiceImpl.findByName(user.getName());

        if (userFromDb != null) {//если есть
            model.put("message", "User exists!");
            return "registration";
        }

        userServiceImpl.addNewUser(user);
        return "/login";
    }

}


