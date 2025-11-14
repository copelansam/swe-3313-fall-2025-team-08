package com.example.ecommerce.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShippingAddressRepository {

    private final JdbcTemplate jdbc;

    public ShippingAddressRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }
}
