package com.trip.controller;

import com.trip.model.User;
import com.trip.repository.UserCrudRepository;
import com.trip.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private final UserServiceImpl userService;
    private final UserCrudRepository userCrudRepository;

    public UserController(UserServiceImpl userService, UserCrudRepository userCrudRepository) {
        this.userService = userService;
        this.userCrudRepository = userCrudRepository;
    }

    @GetMapping("/admin")
    public String useradd(Map<String, Object> model) {
        Iterable<User> users = userService.findAll();

        model.put("messages", users);

        return "admin";
    }

    @PostMapping("/admin")
    public String add(@RequestParam Long id, @RequestParam String name, @RequestParam String email, Map<String, Object> model) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);

        userService.delete(user);

        Iterable<User> messages = userService.findAll();

        model.put("messages", messages);

        return "admin";
    }

    @PostMapping("filter")// мэпинг куда уходят данные
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<User> users;

        if (filter != null && !filter.isEmpty()) {
            users = userService.filter(filter);
        } else {
            users = userService.findAll();
        }

        model.put("messages", users);

        return "admin";
    }

}