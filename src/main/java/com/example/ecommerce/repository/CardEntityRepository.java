package com.example.ecommerce.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CardEntityRepository {

    private final JdbcTemplate jdbc;

    public CardEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }
}
