package com.example.ecommerce.service;

import com.example.ecommerce.model.Item;
import com.example.ecommerce.repository.ItemEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemEntityService {

    public final ItemEntityRepository itemTable;

    public ItemEntityService(ItemEntityRepository itemTable){

        this.itemTable = itemTable;
    }

    public List<Item> loadInventory(String search){

        if (search == null || search == "") {

            return itemTable.retrieveAvailableItems();
        }
        else{

            String pattern = "%" + search + "%";

            return itemTable.inventorySearch(pattern);
        }
    }
}
