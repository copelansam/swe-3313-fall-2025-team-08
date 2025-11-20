package com.example.ecommerce.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserEntityRepository {

    private final JdbcTemplate jdbc;

    public UserEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;

    }

    public void addRow(String name, String userName, String email, String password) {

        String userSql = "INSERT INTO User(name, userName, email, password, isAdmin) VALUES (?, ?, ?, ?, FALSE)";

        jdbc.update(userSql, name, userName, email, password);

    }

    public boolean usernameUnique(String userName){

        String usernameUniqueSql = "SELECT Count(*) FROM User WHERE userName = ?";

        int usernameOccurrence = jdbc.queryForObject(usernameUniqueSql, Integer.class, userName);

        if (usernameOccurrence == 0){

            return true;
        }
        else{

            return false;
        }

    }
}
