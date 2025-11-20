package com.example.ecommerce.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderLineEntityRepository {

    private final JdbcTemplate jdbc;

    public OrderLineEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }

    public void addRow(int itemid, int orderid) {
        String orderLineSql = "INSERT INTO Order_Line(itemid, orderid) VALUES(?,?)";
        jdbc.update(orderLineSql, itemid, orderid);
    }
}
