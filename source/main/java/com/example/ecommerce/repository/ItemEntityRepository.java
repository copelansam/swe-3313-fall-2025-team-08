package com.example.ecommerce.repository;

import com.example.ecommerce.model.Item;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ItemEntityRepository {

    private final JdbcTemplate jdbc;

    public ItemEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }

    // Add new item to the database
    public void addRow(String name, String description, String imagePath, BigDecimal price, boolean inStock) {

        String itemSql = "INSERT INTO Item(name, description, imagePath, price, inStock) VALUES(?, ?, ?, ?, ?)";

        jdbc.update(itemSql, name, description, imagePath, price, inStock);
    }

    // Return a list of items based on the value that was entered into the search bar
    public List<Item> inventorySearch(String pattern){

        String query = "SELECT * FROM Item WHERE inStock = true " +
                "AND (name LIKE ? OR description LIKE ?)" +
                " ORDER BY price DESC";

        return jdbc.query(query, new Object[]{pattern,pattern},(rs,rowNum)->{

            Item item = new Item();

            item.setItemId(rs.getInt("itemId"));

            item.setName(rs.getString("name"));

            item.setDescription(rs.getString("description"));

            item.setImagePath(rs.getString("imagePath"));

            item.setPrice(rs.getBigDecimal("price"));

            return item;
        });
    }

    // Return an item based on the provided itemId
    public Item findItemById(int itemId){

        String query = "SELECT * FROM Item WHERE itemId = ?";

        return jdbc.queryForObject(query,new Object[] {itemId}, (rs,rowNum)->{

            Item item = new Item();

            item.setItemId(rs.getInt("itemId"));

            item.setName(rs.getString("name"));

            item.setDescription(rs.getString("description"));

            item.setImagePath(rs.getString("imagePath"));

            item.setPrice(rs.getBigDecimal("price"));

            return item;
        });
    }
}
