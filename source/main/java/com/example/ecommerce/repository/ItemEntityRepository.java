package com.example.ecommerce.repository;

import com.example.ecommerce.model.Item;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    public void retrieveItemInfo() {
        jdbc.execute( "SELECT * FROM Item " +
                "WHERE inStock = TRUE");
    }

    public void inventorySearch(String search) {

        String pattern = "%" + search + "%";

        String query = "SELECT * FROM Item WHERE inStock = true " +
                "AND (name LIKE ? OR description LIKE ?)" +
                "ORDER BY price DESC";

        jdbc.query(query,
                new Object[]{pattern,pattern},
                new BeanPropertyRowMapper<>(Item.class));
    }

    public void itemSoldWithinDays(String x) {
        jdbc.execute("SELECT * FROM Item " +
                "WHERE itemid IN (" +
                "SELECT itemid FROM Order_Line " +
                "WHERE orderid IN (" +
                "SELECT orderid " +
                "FROM 'Order' " +
                "WHERE orderDate >= DATE('now', '-' || x || ' days'))");
    }
}
