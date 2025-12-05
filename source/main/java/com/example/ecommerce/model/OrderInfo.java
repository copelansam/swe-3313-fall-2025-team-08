package com.example.ecommerce.model;

// Object of this class will store info relevant to a user placing an order.
// They will be stored in the session upon being entered, and will be pulled to create
// the necessary entities in the database
import java.math.BigDecimal;
import java.text.NumberFormat;

public class OrderInfo {

    private int orderId;

    private String city;

    private String state;

    private String zip;

    private String streetAddress;

    private String creditCardNumber;

    private String expirationMonth;

    private String expirationYear;

    private String securityCode;

    private String shippingName;

    private String shippingType;

    private String shippingCost;

    private String formattedShippingCost;

    private BigDecimal grandTotal;

    private BigDecimal subTotal;

    private String formattedGrandTotal;

    private int userId;

    public OrderInfo() {

    }

    public OrderInfo(String city, String state, String zip, String streetAddress, String creditCardNumber, String expirationMonth, String expirationYear, String securityCode,String shippingName, String shippingType, String shippingCost, BigDecimal subTotal, int userId) {

        this.city = city;

        this.state = state;

        this.zip = zip;

        this.streetAddress = streetAddress;

        this.creditCardNumber = creditCardNumber;

        this.expirationMonth = expirationMonth;

        this.expirationYear = expirationYear;

        this.securityCode = securityCode;

        this.shippingName = shippingName;

        this.shippingType = shippingType;

        this.shippingCost = shippingCost;

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        this.formattedShippingCost = currency.format(Integer.parseInt(shippingCost));

        this.subTotal = subTotal;

        grandTotal = this.subTotal.add(new BigDecimal(shippingCost));

        this.formattedGrandTotal = currency.format(grandTotal);

        this.userId = userId;

    }

    public String getShippingName(){

        return this.shippingName;
    }

    public String getStreetAddress(){

        return this.streetAddress;
    }

    public String getCity(){

        return this.city;
    }

    public String getState(){

        return this.state;
    }

    public String getZip(){

        return this.zip;
    }

    public String getShippingType(){
        return this.shippingType;
    }

    public String getShippingCost(){

        return this.shippingCost;
    }

    public String getFormattedShippingCost(){

        return this.formattedShippingCost;
    }

    public String getCreditCardNumber(){
        return this.creditCardNumber;
    }

    public String getExpirationMonth(){

        return this.expirationMonth;
    }

    public String getExpirationYear(){

        return this.expirationYear;
    }

    public String getSecurityCode(){

        return this.securityCode;
    }

    public BigDecimal getGrandTotal(){

        return this.grandTotal;
    }

    public String getFormattedGrandTotal(){

        return this.formattedGrandTotal;
    }

    public int getUserId(){

        return this.userId;
    }

    public void setOrderId(int orderId){

        this.orderId = orderId;
    }

    public int getOrderId(){

        return orderId;
    }

}
