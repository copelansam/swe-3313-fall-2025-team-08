package com.example.ecommerce.model;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Item> items = new ArrayList<>();

    private BigDecimal subtotal=BigDecimal.ZERO;

    private String formattedSubtotal;

    private BigDecimal taxes=BigDecimal.ZERO;

    private String formattedTaxes;

    private BigDecimal grandTotal=BigDecimal.ZERO;

    private String formattedGrandTotal;

    private String shippingOption;

    private static final BigDecimal taxRate = new  BigDecimal("0.06");

    public Cart() {}

    public List<Item> getItems() {return items;}

    public void setItems(List<Item> items){

        this.items = items;

        recalculateTotals();
    }

    public BigDecimal getSubtotal() {return subtotal;}

    public String getFormattedSubtotal(){

        return this.formattedSubtotal;
    }

    public  BigDecimal getTaxes() {return taxes;}

    public String getFormattedTaxes(){

        return this.formattedTaxes;
    }

    public  BigDecimal getGrandTotal() {return grandTotal;}

    public String getFormattedGrandTotal(){

        return this.formattedGrandTotal;
    }

    public String getShippingOption() {return shippingOption;}

    public BigDecimal getTaxRate() {return taxRate;}


    public void setShippingOption(String shippingOption) {
        this.shippingOption = shippingOption;
    }

    // recalculate various totals/prices in the cart
    private void recalculateTotals() {

        subtotal=BigDecimal.ZERO;

        for (Item item : items) {

            if (item != null && item.getPrice() != null) {

                subtotal=subtotal.add(item.getPrice());
            }
        }

        formattedSubtotal = formatPrice(subtotal);

        taxes = subtotal.multiply(taxRate);

        formattedTaxes = formatPrice(taxes);

        grandTotal = subtotal.add(taxes);

        formattedGrandTotal = formatPrice(grandTotal);
    }

    public void addItem(Item item) {

        if (item == null) {

            return;
        }

        items.add(item);

        recalculateTotals();
    }

    public void removeItemById(int itemId) {

        items.removeIf(item -> item.getItemId() == itemId);

        recalculateTotals();
    }

    // check to see if an item is already present in the cart by comparing itemIds
    public boolean itemPresentInCart(int itemId){

        for (Item item : items){

            if (item.getItemId() == itemId){

                return true;
            }
        }

        return false;
    }

    // remove all items from the cart
    public void clear() {

        items.clear();

        recalculateTotals();

        shippingOption = null;
    }

    // format prices to include appropriate commas, decimals, and dollar signs
    public String formatPrice(BigDecimal price){

        NumberFormat currency = NumberFormat.getCurrencyInstance(); // Written by ChatGPT

        return currency.format(price);

    }
}
