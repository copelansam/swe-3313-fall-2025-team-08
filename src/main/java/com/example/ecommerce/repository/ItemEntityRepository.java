package com.example.ecommerce.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemEntityRepository {

    private final JdbcTemplate jdbc;

    public ItemEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }
}
