package com.example.ecommerce.model;

// Object of this class will store info relevant to a user placing an order.
// They will be stored in the session upon being entered, and will be pulled to create
// the necessary entities in the database

import java.math.BigDecimal;
import java.text.NumberFormat;

public class OrderInfo {

    String city;

    String state;

    String zip;

    String streetAddress;

    String creditCardNumber;

    String expirationMonth;

    String expirationYear;

    String securityCode;

    String shippingName;

    String shippingCost;

    String formattedShippingCost;

    BigDecimal grandTotal;

    BigDecimal subTotal;

    String formattedGrandTotal;

    public OrderInfo() {

    }

    public OrderInfo(String city, String state, String zip, String streetAddress, String creditCardNumber, String expirationMonth, String expirationYear, String securityCode,String shippingName, String shippingCost, BigDecimal subTotal) {

        this.city = city;

        this.state = state;

        this.zip = zip;

        this.streetAddress = streetAddress;

        this.creditCardNumber = creditCardNumber;

        this.expirationMonth = expirationMonth;

        this.expirationYear = expirationYear;

        this.securityCode = securityCode;

        this.shippingName = shippingName;

        this.shippingCost = shippingCost;

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        this.formattedShippingCost = currency.format(Integer.parseInt(shippingCost));

        this.subTotal = subTotal;

        grandTotal = this.subTotal.add(new BigDecimal(shippingCost));

        this.formattedGrandTotal = currency.format(grandTotal);

    }

}
