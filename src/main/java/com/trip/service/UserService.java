package com.trip.service;

import com.trip.model.User;
import com.trip.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User add(User user) {
            return userDao.addUser(user);
    }

    public User getById(long id) {
        System.out.println("UserService get ");
        return userDao.getUserById(id);
    }
    public User getByName(String name) {
        System.out.println("UserService get ");
        return userDao.getUserByName(name);
    }

    public boolean delete(long id) {
        System.out.println("UserService delete ");
        return userDao.deleteUserById(id);
    }
}
