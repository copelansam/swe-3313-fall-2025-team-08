package com.example.ecommerce.service;

import com.example.ecommerce.repository.OrderAddressEntityRepository;

public class OrderAddressEntityService {

    public final OrderAddressEntityRepository orderAddressTable;

    public OrderAddressEntityService(OrderAddressEntityRepository orderAddressTable){

        this.orderAddressTable = orderAddressTable;
    }
}
