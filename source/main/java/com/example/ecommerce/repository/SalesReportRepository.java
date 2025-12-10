package com.example.ecommerce.repository;

import com.example.ecommerce.model.Item;
import com.example.ecommerce.model.ReportItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// This repository will contain the query for retrieving sales reports
@Repository
public class SalesReportRepository {

    private final JdbcTemplate jdbc;

    public SalesReportRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;
    }

    // retrieves all of the items sold within a user specified time frame, includes relevant information
    public List<ReportItem> salesReport(int timeDay){

        String query = "SELECT [Order].orderId," +
                                "[Order].orderDate," +
                                "Item.price, " +
                                "Item.name AS [itemName]," +
                                "Item.imagePath," +
                                "User.name " +
                                "FROM [Order] " +
                                "JOIN User ON [Order].userId = User.userId " +
                                "JOIN Order_Line ON [Order].orderId = Order_Line.orderId " +
                                "JOIN Item ON Item.itemId = Order_Line.itemId " +
                                "WHERE (julianday('now') - julianday([Order].orderDate) <= ?)";

        return jdbc.query(query, new Object[]{timeDay},(rs,rowNum)->{

            ReportItem item = new ReportItem();

            item.setName(rs.getString("itemName"));

            item.setDatePurchased(rs.getString("orderDate"));

            item.setImagePath(rs.getString("imagePath"));

            item.setOrderNumber(rs.getString("orderId"));

            item.setPriceRaw(rs.getBigDecimal("price"));

            item.setPurchasedBy(rs.getString("name"));

            return item;
        });

    }
}
