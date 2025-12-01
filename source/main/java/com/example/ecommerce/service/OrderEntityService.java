package com.example.ecommerce.service;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.Item;
import com.example.ecommerce.model.ValidateOrderCredentials;
import com.example.ecommerce.model.OrderInfo;
import com.example.ecommerce.repository.OrderAddressEntityRepository;
import com.example.ecommerce.repository.OrderCardEntityRepository;
import com.example.ecommerce.repository.OrderEntityRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderEntityService {

    public final OrderEntityRepository orderTable;

    public OrderEntityService(OrderEntityRepository orderTable){

        this.orderTable = orderTable;
    }

    public ValidateOrderCredentials validateOrderInput(String city, String state, String zip, String streetAddress,
                                                       String creditCardNumber, String expirationMonth, String expirationYear,
                                                       String securityCode, String shippingName, String shipping, Cart cart,
                                                       int userId) {

        if (city.isEmpty() || state.isEmpty() || zip.isEmpty() || streetAddress.isEmpty() || shippingName.isEmpty() || creditCardNumber.isEmpty() || expirationMonth.equals("") || expirationYear.equals("") ||securityCode.isEmpty()){

            return new ValidateOrderCredentials(false,"Please make sure that all fields are filled out",null);
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

        OrderInfo orderInfoSession = new OrderInfo(city, state.toUpperCase(), zip, streetAddress, creditCardNumber, expirationMonth, expirationYear, securityCode, shippingName, shippingInfo[0],shippingInfo[1],(cart.getSubtotal()).add(cart.getTaxes()), userId);

        return new ValidateOrderCredentials(true, null, orderInfoSession);
    }

    public int createOrder(OrderInfo orderInfo, Cart cart){


        // creates order in database
        orderTable.addOrder(orderInfo.getUserId(),cart.getSubtotal(),new BigDecimal(orderInfo.getShippingCost()),
                cart.getTaxes(),orderInfo.getGrandTotal(), orderInfo.getShippingType());

        int orderId = orderTable.getLatestOrder();

        for (Item item : cart.getItems()){

            // associates items with order
            orderTable.addOrderLine(item.getItemId(),orderId);

            // remove item from available inventory
            orderTable.sellItem(item.getItemId());

        }

        orderTable.setAddress(orderInfo.getStreetAddress(), orderInfo.getCity(), orderInfo.getState(), orderInfo.getZip(), orderId);

        orderTable.setCreditCard(orderInfo.getCreditCardNumber(),orderInfo.getExpirationMonth(),orderInfo.getExpirationYear(),orderInfo.getSecurityCode(),orderId);

        return orderId;
    }
}
