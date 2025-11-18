package com.example.ecommerce.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserEntityRepository {

    private final JdbcTemplate jdbc;

    public UserEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;

    }
}
