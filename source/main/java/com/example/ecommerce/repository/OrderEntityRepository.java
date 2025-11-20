package com.example.ecommerce.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class OrderEntityRepository {

    private final JdbcTemplate jdbc;

    public OrderEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }

    public void addRow(int userid, String orderDate, BigDecimal subtotal, BigDecimal shippingPrice, BigDecimal taxes, BigDecimal grandTotal, String shippingSelection) {
        String orderSql = "INSERT INTO 'Order'(userid, orderDate, subTotal, shippingPrice, taxes, GrandTotal, shippingSelection) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbc.update(orderSql, userid, orderDate, subtotal, shippingPrice, taxes, grandTotal);
    }
}
