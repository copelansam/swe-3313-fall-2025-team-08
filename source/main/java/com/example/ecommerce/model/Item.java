package com.example.ecommerce.model;
import java.math.BigDecimal;
public class Item {
    private String itemName;
    private String description;
    private String filepath;
    private BigDecimal price;

    public Item(String itemName, String description, BigDecimal price, String filepath) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.filepath = filepath;
    }

    public Item() {}

    public String getItemName() {return itemName;}
    public void setItemName(String itemName) {this.itemName = itemName;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public BigDecimal getPrice() {return price;}
    public void setPrice(BigDecimal price) {this.price = price;}

    public String getFilepath() {return filepath;}
    public void setFilepath(String filepath) {this.filepath = filepath;}
}



