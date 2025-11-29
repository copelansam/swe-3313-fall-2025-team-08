package com.example.ecommerce.model;

// Object of this class will store info relevant to a user placing an order.
// They will be stored in the session upon being entered, and will be pulled to create
// the necessary entities in the database

public class OrderInfo {

    String city;

    String state;

    String zip;

    String streetAddress;

    String creditCardNumber;

    String ExpirationMonth;

    String ExpirationYear;

    String securityCode;

    String shippingName;

    String shippingType;

    public OrderInfo() {

    }

    public OrderInfo(String city, String state, String zip, String streetAddress, String creditCardNumber, String ExpirationMonth, String ExpirationYear, String securityCode,String shippingName, String shippingType) {

        this.city = city;

        this.state = state;

        this.zip = zip;

        this.streetAddress = streetAddress;

        this.creditCardNumber = creditCardNumber;

        this.ExpirationMonth = ExpirationMonth;

        this.ExpirationYear = ExpirationYear;

        this.securityCode = securityCode;

        this.shippingName = shippingName;

        this.shippingType = shippingType;
    }
}
