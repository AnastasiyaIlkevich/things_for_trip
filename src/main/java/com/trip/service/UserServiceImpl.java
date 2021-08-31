package com.trip.service;

import com.trip.model.Role;
import com.trip.model.User;
import com.trip.repository.RoleJpaRepository;
import com.trip.repository.UserJpaRepository;
import com.trip.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserJpaRepository userJpaRepository;

    @Autowired
    private final RoleJpaRepository roleJpaRepository;

    @Autowired
    private final UserCrudRepository userCrudRepository;

    public UserServiceImpl(UserJpaRepository userJpaRepository, RoleJpaRepository roleJpaRepository, UserCrudRepository userCrudRepository) {
        this.userJpaRepository = userJpaRepository;
        this.roleJpaRepository = roleJpaRepository;
        this.userCrudRepository = userCrudRepository;
    }

     @Override
    public void addNewUser(User user) {
        System.out.println("addNewUser");
        user.setActive(true);
        Set<Role> roles = new HashSet<>();
        roles.add(roleJpaRepository.getOne(1L));
        user.setRoles(roles);
        userJpaRepository.save(user);
    }

    @Override
    public User findByName(String name) {
        return userJpaRepository.findByName(name);
    }

    @Override
    public List<User> filter(String filter) {
        return userCrudRepository.findByName(filter);
    }


    @Override
    public Iterable<User> findAll() {
        return userCrudRepository.findAll();
    }

    @Override
    public void delete(User user) {
        try {
            userCrudRepository.delete(user);
        }catch (Throwable ex){
            System.out.println(ex.getMessage());
        }

    }
}
