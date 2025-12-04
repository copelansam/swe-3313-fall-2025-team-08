package com.example.ecommerce.model;

import java.math.BigDecimal;
import java.text.NumberFormat;

// Objects of this class will contain the information that we want to display in our sales reports

public class ReportItem {

    private String name;

    private String formattedPrice;

    private BigDecimal priceRaw;

    private String datePurchased;

    private String orderNumber;

    private String imagePath;

    private String purchasedBy;

    public void setName(String name){

        this.name = name;
    }

    public String getName(){

        return this.name;
    }

    public void setPriceRaw(BigDecimal priceRaw){

        this.priceRaw = priceRaw;

        this.formattedPrice = formatPrice(priceRaw);
    }

    public BigDecimal getPriceRaw(){

        return this.priceRaw;
    }

    public String getFormattedPrice(){

        return this.formattedPrice;
    }

    public void setDatePurchased(String datePurchased){

        this.datePurchased = datePurchased;
    }

    public String getDatePurchased(){

        return this.datePurchased;
    }

    public void setImagePath(String imagePath){

        this.imagePath = imagePath;
    }

    public String getImagePath(){

        return imagePath;
    }

    public void setOrderNumber(String orderNumber){

        this.orderNumber = orderNumber;
    }

    public String getOrderNumber(){

        return orderNumber;
    }

    public String formatPrice(BigDecimal price){

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        return currency.format(price);
    }

    public void setPurchasedBy(String purchasedBy){

        this.purchasedBy = purchasedBy;
    }

    public String getPurchasedBy(){

        return this.purchasedBy;
    }

    public String toCSV(){

        // CSV for the exported report
        return getName() + ",\"" + getFormattedPrice() + "\"," + getDatePurchased() + "," + getOrderNumber() + "," + getPurchasedBy() + "\n";
    }
}
