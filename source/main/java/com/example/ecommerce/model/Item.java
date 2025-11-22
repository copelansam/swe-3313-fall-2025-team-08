package com.example.ecommerce.model;
import java.math.BigDecimal;
public class Item {
    private int itemId;
    private String name;
    private String description;
    private String imagePath;
    private BigDecimal price;

    public Item(int itemId, String itemName, String description, BigDecimal price, String filepath) {
        this.itemId = itemId;
        this.name = itemName;
        this.description = description;
        this.price = price;
        this.imagePath = filepath;
    }

    public Item() {}

    public String getName() {return name;}
    public void setItemName(String itemName) {this.name = itemName;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public BigDecimal getPrice() {return price;}
    public void setPrice(BigDecimal price) {this.price = price;}

    public String getImagePath() {return imagePath;}
    public void setFilepath(String filepath) {this.imagePath = filepath;}

    public int getItemId(){return this.itemId;}
    public void setItemId(int itemId){this.itemId = itemId;}

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + name + '\'' +
                ", description='" + description + '\'' +
                ", filepath='" + imagePath + '\'' +
                ", price=" + price +
                '}';
    }
}



