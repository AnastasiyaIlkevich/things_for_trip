package com.trip.repository;

import com.trip.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository("userDaoInternal")
public class UserDaoInternal implements UserDao {

    private final String sqlAdd = "insert into users (name,password, email) values (?,?,?)";
    private final String sqlGetId = "select u.id as id, u.name as name, u.password as password, u.email as email from users u where id = ?";
    private final String sqlDelete = "delete from users where id = ?";
    private final String sqlGetName = "select * from users where users.name = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User addUser(User user) {
        User userDataBase = getUserByName(user);
        if (userDataBase != null) {
            System.out.println("user уже существует");
            return userDataBase;
        } else {
            jdbcTemplate.update(sqlAdd, user.getName(), user.getPassword(), user.getEmail());
            return user;
        }
    }

    public User getUserById(long id) {
        return jdbcTemplate.queryForObject(sqlGetId, (rs, rn) -> new User(rs.getLong("id"),
                rs.getString("name"),
                rs.getString("password"),
                rs.getString("email")), id);
    }

    public boolean deleteUserById(long id) {
        return jdbcTemplate.update(sqlDelete, id) > 0;
    }

    public User getUserByName(User user) {
        try {
            return jdbcTemplate.queryForObject(sqlGetName, (rs, rn) -> new User(rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("email")), user.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

