package com.example.ecommerce.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class DatabaseInitializer {

    private final JdbcTemplate jdbc;

    public DatabaseInitializer(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // initializes the database by creating all of the tables if they do not already exist
    @PostConstruct
    public void init() {

        jdbc.execute();
    }
}
