package com.example.ecommerce.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderCardEntityRepository {

    private final JdbcTemplate jdbc;

    public OrderCardEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }

    public void addRow(int orderid, int creditCardNumber) {
        String orderCardSql = "INSERT INTO Order_Card(orderid,creditCardNumber) VALUES(?,?)";
        jdbc.update(orderCardSql, orderid, creditCardNumber);
    }
}
