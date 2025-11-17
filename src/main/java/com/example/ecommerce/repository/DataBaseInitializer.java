package com.example.ecommerce.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class DataBaseInitializer {

    private final JdbcTemplate jdbc;

    public DataBaseInitializer(JdbcTemplate jdbc){
        this.jdbc = jdbc;

        jdbc.execute();
    }
}
