package com.example.ecommerce.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderLineRepository {

    private final JdbcTemplate jdbc;

    public OrderLineRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }
}
