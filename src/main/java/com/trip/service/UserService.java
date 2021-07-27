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
        System.out.println("UserService add ");
        try {
           return userDao.addUser(user);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }

    public User get(long id) {
        System.out.println("UserService get ");
        return userDao.getUserId(id);
    }

    public boolean delete(long id) {
        System.out.println("UserService delete ");
        return userDao.deleteUserId(id);
    }
}
