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

    public void addOrder(int userid, BigDecimal subtotal, BigDecimal shippingPrice, BigDecimal taxes,
                       BigDecimal grandTotal, String shippingSelection) {
        String orderSql = "INSERT INTO 'Order'(userid, subTotal, shippingPrice, taxes, GrandTotal, shippingSelection) VALUES (?, ?, ?, ?, ?, ?)";
        jdbc.update(orderSql, userid, subtotal, shippingPrice, taxes, grandTotal, shippingSelection);
    }

    public int getLatestOrder(){
        // used to retrieve the orderId of the order that was just placed
        try {

            String query = "SELECT orderId FROM [Order] ORDER BY orderId DESC LIMIT 1;";

            int orderId = jdbc.queryForObject(query, Integer.class);

            return orderId;
        }
        catch (Exception e){

            System.out.println(e.getMessage());

            return 0;
        }
    }

    public void addOrderLine(int itemId, int orderId) {

        String orderLineSql = "INSERT INTO Order_Line(itemId, orderId) VALUES(?,?)";

        jdbc.update(orderLineSql, itemId, orderId);
    }

    public void sellItem(int itemId){

        String query = "UPDATE Item SET inStock = false WHERE itemId = ?";

        jdbc.update(query,itemId);
    }

    public void setAddress(String streetAddress, String city, String state, String zip, int orderId){

        String addAddressQuery="INSERT OR IGNORE INTO Shipping_Address(streetAddress, city, state, zip) VALUES (?,?,?,?)";

        jdbc.update(addAddressQuery,streetAddress,city,state,zip);

        String addOrderAddressQuery = "INSERT INTO Order_Address(orderId, streetAddress) VALUES(?,?)";

        jdbc.update(addOrderAddressQuery,orderId,streetAddress);

    }

    public void setCreditCard(String creditCardNumber, String expirationMonth, String expirationYear, String securityCode, int orderId){

        String addCardQuery = "INSERT OR IGNORE INTO Card(creditCardNumber, expirationMonth, expirationYear, securityCode) VALUES (?,?,?,?)";

        jdbc.update(addCardQuery,creditCardNumber,expirationMonth,expirationYear,securityCode);

        String addCardOrderQuery = "INSERT INTO Order_Card(orderId,creditCardNumber) VALUES(?,?)";

        jdbc.update(addCardOrderQuery,orderId,creditCardNumber);

    }
}
