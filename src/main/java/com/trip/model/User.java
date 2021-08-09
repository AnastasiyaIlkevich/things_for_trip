package com.trip.model;


import lombok.*;

@Data
public class User {

    private Long id;
    private String name;
    private String password;
    private String email;
    private Role role;

    public User(Long id, String name, String password, String email, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}