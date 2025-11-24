package com.example.ecommerce.model;

import java.math.BigDecimal;

public class Order {
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
