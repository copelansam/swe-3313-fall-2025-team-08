package com.example.ecommerce.model;

// This class will track the success of a user entering their payment and shipping info
public class ValidateOrderCredentials {

    private boolean isValid;

    private String message;

    private OrderInfo orderInfo;

    public ValidateOrderCredentials(boolean isValid, String message, OrderInfo orderInfo) {

        this.isValid = isValid;

        this.message = message;

        this.orderInfo = orderInfo;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }
}
