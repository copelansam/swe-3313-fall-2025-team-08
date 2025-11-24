package com.example.ecommerce.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items = new ArrayList<>();
    private BigDecimal subtotal=BigDecimal.ZERO;
    private BigDecimal taxes=BigDecimal.ZERO;
    private BigDecimal grandTotal=BigDecimal.ZERO;
    private String shippingOption;
    private static final BigDecimal taxRate = new  BigDecimal("0.06");

    public Cart() {}

    public List<Item> getItems() {return items;}
    public BigDecimal getSubtotal() {return subtotal;}
    public  BigDecimal getTaxes() {return taxes;}
    public  BigDecimal getGrandTotal() {return grandTotal;}
    public String getShippingOption() {return shippingOption;}
    public BigDecimal getTaxRate() {return taxRate;}

    public void setShippingOption(String shippingOption) {
        this.shippingOption = shippingOption;
    }

    private void recalculateTotals() {
        subtotal=BigDecimal.ZERO;
        for (Item item : items) {
            if (item != null && item.getPrice() != null) {
                subtotal=subtotal.add(item.getPrice());
            }
        }
        taxes = subtotal.multiply(taxRate);
        grandTotal = subtotal.add(taxes);
    }

    public void addItem(Item item) {
        if (item == null) {
            return;
        }
        items.add(item);
        recalculateTotals();
    }

    public void removeItem(Item item) {
        if (item == null) {
            return;
        }
        items.remove(item);
        recalculateTotals();
    }

    public void clear() {
        items.clear();
        recalculateTotals();
        shippingOption = null;
    }
}
