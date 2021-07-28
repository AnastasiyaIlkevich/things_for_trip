package com.trip.repository;

import com.trip.model.User;

public interface UserDao {

    User addUser(User user);

    User getUserById(long id);

    boolean deleteUserById(long id);

    User getUserByName(User user);
}
