package com.trip.repository;

import com.trip.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository("UserDaoInternal")
public class UserDaoInternal implements UserDao {

    private final String sqlAdd = "insert into users (name,password, email) values (?,?,?)";
    private final String sqlGetId = "select users.id as id, users.name as name, users.password as password, users.email as email from users where id = ?";
    private final String sqlDelete = "delete from users where id = ?";
    private final String sqlGetName = "select users.id as id from users where users.name = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //поиск и добавление
    public User addUser(User user) {

        Long id = null;
        try {
            id = jdbcTemplate.queryForObject(sqlGetName, Long.class, user.getEmail());
        } catch (Exception ignored) {
        }

        if (id != null) {
            System.out.println("user уже существует");
            getUserId(id);
        } else {
            jdbcTemplate.update(sqlAdd, user.getName(), user.getPassword(), user.getEmail());
            return user;
        }
        return user;
    }

    //поиск
    public User getUserId(long id) {
        return jdbcTemplate.queryForObject(sqlGetId, (rs, rn) -> new User(rs.getLong("id"),
                rs.getString("name"),
                rs.getString("password"),
                rs.getString("email")), id);
    }


    //удаление
    public boolean deleteUserId(long id) {
        return jdbcTemplate.update(sqlDelete, id) > 0;
    }
}
