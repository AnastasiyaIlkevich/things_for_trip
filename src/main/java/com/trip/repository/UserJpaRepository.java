package com.trip.repository;

import com.trip.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User,Long> {
    User findByName(String name);
}
