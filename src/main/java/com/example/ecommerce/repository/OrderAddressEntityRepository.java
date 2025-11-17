package com.example.ecommerce.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderAddressEntityRepository {

    private final JdbcTemplate jdbc;

    public OrderAddressEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }
}
