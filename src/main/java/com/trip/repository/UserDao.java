package com.trip.repository;

import com.trip.model.User;

public interface UserDao {

    User addUser(User user);

    User getUserId(long id);

    boolean deleteUserId(long id);
}
