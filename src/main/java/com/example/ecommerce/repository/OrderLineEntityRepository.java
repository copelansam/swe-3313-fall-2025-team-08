package com.example.ecommerce.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderLineEntityRepository {

    private final JdbcTemplate jdbc;

    public OrderLineEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }
}
