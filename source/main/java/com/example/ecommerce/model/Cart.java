package com.example.ecommerce.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items;
    private String shippingOption;
    private BigDecimal grandTotal;
    private BigDecimal subtotal;
    private BigDecimal taxes;

    public Cart(){

    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }
}
