package com.example.ecommerce.service;

import com.example.ecommerce.repository.ItemEntityRepository;

public class ItemEntityService {

    public final ItemEntityRepository itemTable;

    public ItemEntityService(ItemEntityRepository itemTable){

        this.itemTable = itemTable;
    }
}
