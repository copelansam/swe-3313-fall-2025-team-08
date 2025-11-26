package com.example.ecommerce.model;

public class OrderInfo {
    String city;
    String state;
    String zip;
    String creditCardNumber;
    String ExpirationMonth;
    String ExpirationYear;
    String shippingType;

    public OrderInfo() {

    }

    public OrderInfo(String city, String state, String zip, String creditCardNumber, String ExpirationMonth, String ExpirationYear, String securityCode, String shippingType) {
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.creditCardNumber = creditCardNumber;
        this.ExpirationMonth = ExpirationMonth;
        this.ExpirationYear = ExpirationYear;
        this.shippingType = shippingType;
    }
}
