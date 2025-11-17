package com.example.ecommerce.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderEntityRepository {

    private final JdbcTemplate jdbc;

    public OrderEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }
}
