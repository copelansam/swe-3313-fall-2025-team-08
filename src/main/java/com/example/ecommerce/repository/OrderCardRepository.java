package com.example.ecommerce.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderCardRepository {

    private final JdbcTemplate jdbc;

    public OrderCardRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }
}
