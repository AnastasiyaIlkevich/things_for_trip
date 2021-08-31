package com.trip.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.data.annotation.PersistenceConstructor;


import javax.management.ConstructorParameters;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //   @Size(min=2, message = "Не меньше 2 знаков")
    @Column (name = "name")
    private String name;

    @Column (name = "email")
    private String email;

    //  @Size(min=2, message = "Не меньше 2 знаков")
    @Column(name = "password")
    private String password;

    private boolean active;

    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}