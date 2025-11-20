package com.example.ecommerce.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class ItemEntityRepository {

    private final JdbcTemplate jdbc;

    public ItemEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }

    public void addRow(String name, String description, String imagePath, BigDecimal price, boolean inStock) {
        String itemSql = "INSERT INTO Item(name, description, imagePath, price, inStock) VALUES(?, ?, ?, ?, ?)";
        jdbc.update(itemSql, name, description, imagePath, price, inStock);
    }
}
