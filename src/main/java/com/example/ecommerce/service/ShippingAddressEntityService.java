package com.example.ecommerce.service;

import com.example.ecommerce.repository.ShippingAddressEntityRepository;

public class ShippingAddressEntityService {

    public final ShippingAddressEntityRepository shippingAddressTable;

    public ShippingAddressEntityService(ShippingAddressEntityRepository shippingAddressTable){

        this.shippingAddressTable = shippingAddressTable;
    }
}
