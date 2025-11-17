package com.example.ecommerce.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class DataBaseInitializer {

    // initializes the database by creating all of the tables if they do not exist

    private final JdbcTemplate jdbc;



    public DataBaseInitializer(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @PostConstruct
    public void init() {

        jdbc.execute();
    }

}
