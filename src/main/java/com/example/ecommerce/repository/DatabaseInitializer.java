package com.example.ecommerce.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class DatabaseInitializer {

    private final JdbcTemplate jdbc;

    public DatabaseInitializer(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // initializes the database by creating all of the tables if they do not already exist
    @PostConstruct
    public void init() {

        jdbc.execute( "CREATE TABLE IF NOT EXISTS User ( userid    integer PRIMARY KEY, ame      varchar(100), userName  varchar(100), email     varchar(100), password  varchar(100), " +
                "isAdmin   boolean );" );
        jdbc.execute("CREATE TABLE IF NOT EXISTS Shipping_Address ( streetAddress varchar(100) PRIMARY KEY, city          varchar(50), state         char(2), zip           " +
                "char(5) );");
        jdbc.execute("CREATE TABLE IF NOT EXISTS Order ( orderid           integer PRIMARY KEY, userid            int NOT NULL, orderDate         date, subTotal          numeric, shippingPrice     numeric, taxes             numeric, grandTotal        numeric, shippingSelection varchar(100), " +
                "FOREIGN KEY (userid) references User(userid) );");
        jdbc.execute("CREATE TABLE IF NOT EXISTS Item( itemid       integer PRIMARY KEY, name         varchar(100), description  varchar(1000), imagePath    varchar(50), price        numeric, " +
                "inStock      boolean );");
        jdbc.execute("CREATE TABLE IF NOT EXISTS Card( creditCardNumber char(16) PRIMARY KEY, expirationMonth  char(2), expirationYear   char(2), " +
                "securityCode     char(3) );");
        jdbc.execute("CREATE TABLE IF NOT EXISTS Order_Address ( orderid               integer, streetAddress         integer, PRIMARY KEY (orderid, streetAddress), FOREIGN KEY (orderid) references Order(orderid), " +
                "FOREIGN KEY (streetAddress) references Shipping_Address(streetAddress) );");
        jdbc.execute("CREATE TABLE IF NOT EXISTS Order_Card  ( orderid               integer, creditCardNumber      integer, PRIMARY KEY (orderid, creditCardNumber), FOREIGN KEY (orderid) references Order(orderid), " +
                "FOREIGN KEY (creditCardNumber) references Card(creditCardNumber) );");
        jdbc.execute("CREATE TABLE IF NOT EXISTS Order_Line ( itemid      integer, orderid     integer, PRIMARY KEY (itemid, orderid), FOREIGN KEY (itemid) references Item(itemid), " +
                "FOREIGN KEY (orderid) references Order(orderid) );");
    }
}
