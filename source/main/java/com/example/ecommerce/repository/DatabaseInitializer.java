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

        // SQLite will treat integer primary key as an alias for autoincrement. Meaning that if it is not specified
        // then it will automatically assign it an unused value

        jdbc.execute("DROP TABLE User");

        jdbc.execute( "CREATE TABLE IF NOT EXISTS User ( " +
                "userId    integer PRIMARY KEY, " +
                "name      varchar(100), " +
                "userName  varchar(100) UNIQUE, " +
                "email     varchar(100), " +
                "password  varchar(100), " +
                "isAdmin   boolean " +
                ");" );

        // User table seed data

        jdbc.execute("INSERT OR IGNORE INTO User " +
                "(userId,name,userName,email,password,isAdmin)" +
                "VALUES (1,'PGAdmin','Admin','PGAdmin@yahoo.net','PGAdmin',true);");

        jdbc.execute("INSERT OR IGNORE INTO User " +
                "(userId,name,userName,email,password,isAdmin)" +
                "VALUES (2,'Steve Man','c00lm4n','coolguy@gmail.com','123456',false);");

        jdbc.execute("INSERT OR IGNORE INTO User " +
                "(userId,name,userName,email,password,isAdmin)" +
                "VALUES (3,'Professor Doctor','learning','1234learning@att.net','m4th1sfun',false);");

        jdbc.execute("CREATE TABLE IF NOT EXISTS Shipping_Address (" +
                "streetAddress varchar(100) PRIMARY KEY, " +
                "city          varchar(50), " +
                "state         char(2), " +
                "zip           char(5) " +
                ");");

        jdbc.execute("CREATE TABLE IF NOT EXISTS `Order` ( " +
                "orderId           integer PRIMARY KEY, " +
                "userId            int NOT NULL, " +
                "orderDate         date, " +
                "subTotal          numeric, " +
                "shippingPrice     numeric, " +
                "taxes             numeric, " +
                "grandTotal        numeric, " +
                "shippingSelection varchar(100), " +
                "FOREIGN KEY (userid) references User(userid) " +
                ");");

        jdbc.execute("DROP TABLE Item");

        jdbc.execute("CREATE TABLE IF NOT EXISTS Item( " +
                "itemId       integer PRIMARY KEY AUTOINCREMENT, " +
                "name         varchar(100), " +
                "description  varchar(1000), " +
                "imagePath    varchar(50), " +
                "price        numeric, " +
                "inStock      boolean " +
                ");");

        // Item table seed data

        jdbc.execute("INSERT OR IGNORE INTO Item (name,description,imagePath,price,inStock)" +
                "VALUES ('The Mona Lisa','The famous oil painting by Leonardo DiVinci. Her smile is the envy of the world'," +
                "'/images/mona-lisa.png',10000.57,true)");

        jdbc.execute("INSERT OR IGNORE INTO Item (name,description,imagePath,price,inStock)" +
                "VALUES ('The Scream','The famous oil painting depicting true horror','/images/scream.png',234593.90, true)");

        jdbc.execute("INSERT OR IGNORE INTO Item (name,description,imagePath,price,inStock)" +
                "VALUES ('The Starry Night','The famous painting of a starry night sky','/images/starry-night.png',47.87,true)");

        jdbc.execute("INSERT OR IGNORE INTO Item (name,description,imagePath,price,inStock)" +
                "VALUES ('Girl With a Pearl Earring','A painting depicting a girl with a pearl earring','/images/pearl-earring.png',357.43,true)");

        jdbc.execute("INSERT OR IGNORE INTO Item (name,description,imagePath,price,inStock)" +
                "VALUES ('The Birth of Venus','A painting depicting the goddess Venus just after her birth'," +
                "'/images/venus-birth.png',12345.67,true)");


        jdbc.execute("CREATE TABLE IF NOT EXISTS Card( " +
                "creditCardNumber char(16) PRIMARY KEY, " +
                "expirationMonth  char(2), " +
                "expirationYear   char(2), " +
                "securityCode     char(3) " +
                ");");

        jdbc.execute("CREATE TABLE IF NOT EXISTS Order_Address ( " +
                "orderId               integer," +
                "streetAddress         varchar(100), " +
                "PRIMARY KEY (orderId, streetAddress)," +
                "FOREIGN KEY (orderId) references `Order`(orderId), " +
                "FOREIGN KEY (streetAddress) references Shipping_Address(streetAddress) " +
                ");");

        jdbc.execute("CREATE TABLE IF NOT EXISTS Order_Card  ( " +
                "orderId               integer," +
                "creditCardNumber      integer," +
                "PRIMARY KEY (orderId, creditCardNumber), " +
                "FOREIGN KEY (orderId) references `Order`(orderId), " +
                "FOREIGN KEY (creditCardNumber) references Card(creditCardNumber) " +
                ");");

        jdbc.execute("CREATE TABLE IF NOT EXISTS Order_Line ( " +
                "itemId      integer, " +
                "orderId     integer, " +
                "PRIMARY KEY (itemId, orderId), " +
                "FOREIGN KEY (itemId) references Item(itemId), " +
                "FOREIGN KEY (orderId) references `Order`(orderId) " +
                ");");

    }
}
