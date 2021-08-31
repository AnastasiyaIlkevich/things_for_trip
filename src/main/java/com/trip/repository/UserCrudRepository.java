package com.trip.repository;

import com.trip.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCrudRepository extends CrudRepository<User, Long> {

    List<User> findByName(String filter);

}
