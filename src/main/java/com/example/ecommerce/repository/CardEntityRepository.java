package com.example.ecommerce.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CardEntityRepository {

    private final JdbcTemplate jdbc;

    public CardEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }

    public void addRow(String creditCardNumber, String expirationMonth, String expirationYear, String securityCode) {
        String cardSql = "INSERT INTO Card(creditCardNumber, expirationMonth, expirationYear, securityCode) VALUES(?, ?, ?, ?)";
        jdbc.update(cardSql, creditCardNumber, expirationMonth, expirationYear, securityCode);
    }
}
