package com.lt.spring.labs.Repo;


import com.lt.spring.labs.entities.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private JdbcTemplate jdbcTemplate;
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void addUser(String firstName, String lastName) {
        String query = "INSERT INTO users (\"first_name\", \"last_name\") VALUES(?,?) ";
        jdbcTemplate.update(query,
                new Object[]{firstName, lastName});
    }

    @Override
    public User getUser(Long id) {
        String query = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(query,
                getRowMapper(), id);
    }

    @Override
    public Iterable<User> getUsers() {
        String query = "SELECT \"id\", \"first_name\", \"last_name\" FROM users";
        return jdbcTemplate.query(query,
                getRowMapper());
    }
    public RowMapper<User> getRowMapper() {
        return new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User u = new User();
                u.setId(rs.getLong("id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                return u;
            }
        };
    }
}
