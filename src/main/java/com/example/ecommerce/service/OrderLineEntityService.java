package com.example.ecommerce.service;

import com.example.ecommerce.repository.OrderLineEntityRepository;

public class OrderLineEntityService {

    public final OrderLineEntityRepository orderLineTable;

    public OrderLineEntityService(OrderLineEntityRepository orderLineTable){

        this.orderLineTable = orderLineTable;
    }
}
