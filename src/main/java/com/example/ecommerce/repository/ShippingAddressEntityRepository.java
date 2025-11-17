package com.example.ecommerce.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShippingAddressEntityRepository {

    private final JdbcTemplate jdbc;

    public ShippingAddressEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }
}
