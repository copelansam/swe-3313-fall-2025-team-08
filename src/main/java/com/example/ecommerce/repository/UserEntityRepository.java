package com.example.ecommerce.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserEntityRepository {

    private final JdbcTemplate jdbc;

    public UserEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;

    }

    public void addRow(String name, String userName, String email, String password, boolean isAdmin) {
        String userSql = "INSERT INTO User(name, email, password, isAdmin) VALUES (?, ?, ?, ?)";
        jdbc.update(userSql, name, userName, email, password);
    }
}
