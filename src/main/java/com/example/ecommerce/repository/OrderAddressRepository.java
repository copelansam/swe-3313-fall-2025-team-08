package com.example.ecommerce.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderAddressRepository {

    private final JdbcTemplate jdbc;

    public OrderAddressRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }
}
