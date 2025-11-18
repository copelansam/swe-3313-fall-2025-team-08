package com.example.ecommerce.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShippingAddressEntityRepository {

    private final JdbcTemplate jdbc;

    public ShippingAddressEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }

    public void addRow(String shippingAddress, String city, String state, String zip) {
        String shippingAddressSql = "INSERT INTO Shipping_Address(shipping_address, city, state, zip) VALUES(?,?,?,?)";
        jdbc.update(shippingAddressSql, shippingAddress, city, state, zip);
    }
}
