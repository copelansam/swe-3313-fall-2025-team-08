package com.example.ecommerce.service;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.ValidateOrderCredentials;
import com.example.ecommerce.model.OrderInfo;
import com.example.ecommerce.repository.OrderAddressEntityRepository;
import com.example.ecommerce.repository.OrderCardEntityRepository;
import com.example.ecommerce.repository.OrderEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderEntityService {

    public final OrderEntityRepository orderTable;

    public OrderEntityService(OrderEntityRepository orderTable){

        this.orderTable = orderTable;
    }

    public ValidateOrderCredentials validateOrderInput(String city, String state, String zip, String streetAddress,
                                                       String creditCardNumber, String expirationMonth, String expirationYear, String securityCode, String shippingName, String shipping, Cart cart) {
        if(city.isEmpty()) {
            return new ValidateOrderCredentials(false, "Please enter a City", null);

        }
        if(state.isEmpty()) {
            return new ValidateOrderCredentials(false, "Please enter a State", null);
        }
        if(zip.isEmpty()) {
            return new ValidateOrderCredentials(false, "Please enter a ZipCode", null);
        }
        if(streetAddress.isEmpty()) {
            return new ValidateOrderCredentials(false, "Please enter a Street Address", null);
        }
        if(creditCardNumber.isEmpty()) {
            return new ValidateOrderCredentials(false, "Please enter the CreditCard Number", null);
        }
        if(expirationMonth.isEmpty()) {
            return new ValidateOrderCredentials(false, "Please enter an Expiration Month", null);
        }
        if(expirationYear.isEmpty()) {
            return new ValidateOrderCredentials(false, "Please enter an Expiration Year", null);
        }
        if(securityCode.isEmpty()) {
            return new ValidateOrderCredentials(false, "Please enter the Security Code", null);
        }
        if(shippingName.isEmpty()) {
            return new ValidateOrderCredentials(false, "Please enter a Shipping Name", null);
        }
        if(shipping.isEmpty()) {
            return new ValidateOrderCredentials(false, "Please enter a Shipping Type", null);
        }
        if(creditCardNumber.length() != 16) {
            return new ValidateOrderCredentials(false, "Please enter a valid Credit Card Number", null);
        }
        if(state.length() != 2) {
            return new ValidateOrderCredentials(false, "Please enter a valid State", null);
        }
        if(zip.length() != 5) {
            return new ValidateOrderCredentials(false, "Please enter a valid ZipCode", null);
        }
        if(!creditCardNumber.matches("^\\d+$")) {
            return new ValidateOrderCredentials(false, "Please enter a valid CreditCard Number", null);
        }

        String[] shippingInfo = shipping.split(" ");

        OrderInfo orderInfoSession = new OrderInfo(city, state, zip, streetAddress, creditCardNumber, expirationMonth, expirationYear, securityCode, shippingName, shippingInfo[0],shippingInfo[1],(cart.getSubtotal()).add(cart.getTaxes()));
        return new ValidateOrderCredentials(true, null, orderInfoSession);
    }
}
