package com.example.ecommerce.service;

import com.example.ecommerce.repository.OrderCardEntityRepository;

public class OrderCardEntityService {

    public final OrderCardEntityRepository orderCardTable;

    public OrderCardEntityService(OrderCardEntityRepository orderCardTable){

        this.orderCardTable = orderCardTable;
    }
}
