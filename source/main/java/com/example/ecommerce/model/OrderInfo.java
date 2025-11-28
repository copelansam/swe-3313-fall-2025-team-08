package com.example.ecommerce.model;

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
