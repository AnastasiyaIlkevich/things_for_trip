package com.trip.service;


import com.trip.model.User;

import java.util.List;


public interface UserService {

    void addNewUser(User user);

    User findByName(String name);

    List<User> filter(String filter);

    Iterable<User> findAll();

    void delete(User user);
}
