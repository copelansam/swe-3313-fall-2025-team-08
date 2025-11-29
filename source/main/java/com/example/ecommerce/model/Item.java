package com.example.ecommerce.model;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class Item {

    private int itemId;

    private String name;

    private String description;

    private String imagePath;

    private BigDecimal price;

    private String formattedPrice;

    public Item(int itemId, String itemName, String description, BigDecimal price, String filepath) {

        this.itemId = itemId;

        this.name = itemName;

        this.description = description;

        this.price = price;

        this.imagePath = filepath;

        this.formattedPrice = formatPrice(price);
    }

    public Item() {}

    public String getName() {return name;}

    public void setName(String itemName) {this.name = itemName;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public BigDecimal getPrice() {return price;}

    public void setPrice(BigDecimal price) {

        this.price = price;

        this.formattedPrice = formatPrice(price);
    }

    public String getFormattedPrice(){

        return  this.formattedPrice;
    }

    public String getImagePath() {return imagePath;}

    public void setImagePath(String filepath) {this.imagePath = filepath;}

    public int getItemId(){return this.itemId;}

    public void setItemId(int itemId){this.itemId = itemId;}


    public String formatPrice(BigDecimal price){

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        return currency.format(price);

    }

    public boolean equals(Item item){

        return this.itemId == item.itemId;
    }

}



