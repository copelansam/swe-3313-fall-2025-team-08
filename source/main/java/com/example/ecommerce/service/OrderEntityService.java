package com.example.ecommerce.service;

import com.example.ecommerce.repository.OrderAddressEntityRepository;
import com.example.ecommerce.repository.OrderCardEntityRepository;
import com.example.ecommerce.repository.OrderEntityRepository;

public class OrderEntityService {

    public final OrderEntityRepository orderTable;

    public OrderEntityService(OrderEntityRepository orderTable){

        this.orderTable = orderTable;
    }
}
