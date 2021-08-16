package com.trip.repository;


import com.trip.model.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository("userDaoInternal")
@Data
public class UserDaoInternal implements UserDao {

    private final String sqlAdd = "insert into users (name,password, email, roles_id) values (?,?,?,?)";
    private final String sqlGetId = "select u.id as id, u.name as name, u.password as password, u.email as email from users u where id = ?";
    private final String sqlDelete = "delete from users where id = ?";
    private final String sqlGetName = "SELECT * from users, roles where users.roles_id = roles.id and users.name = ?";
    private final String sqlSecurityConfigName = "select name,password, 'true' from users where name = ?";
    private final String sqlSecurityConfigRole = "select u.name, roles.name from users u join roles on u.roles_id = roles.id and u.name = ?";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        jdbcTemplate.update(sqlAdd, user.getName(), user.getPassword(), user.getEmail(), 1);
        log.debug("new user added to the database", user);
        return user;
    }


    public User getUserById(long id) {
        return jdbcTemplate.query(sqlGetId, new UserRowMapper(), id).stream().findAny().orElse(null);
    }

    public boolean deleteUserById(long id) {
        return jdbcTemplate.update(sqlDelete, id) > 0;
    }

    public User getUserByName(String name) {
        return jdbcTemplate.query(sqlGetName, new UserRowMapper(), name).stream().findAny().orElse(null);
    }
}
