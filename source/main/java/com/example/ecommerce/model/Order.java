package com.example.ecommerce.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {

    private ArrayList<Item> items;

    private String creditCardNumber;

    private String shippingOption;

    private BigDecimal shippingCost;

    private BigDecimal grandTotal;

    private BigDecimal subtotal;

    private BigDecimal taxes;

    public Order( ){

    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getShippingOption() {
        return shippingOption;
    }


}
