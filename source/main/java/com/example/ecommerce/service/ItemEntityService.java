package com.example.ecommerce.service;

import com.example.ecommerce.model.Item;
import com.example.ecommerce.repository.ItemEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemEntityService {

    public final ItemEntityRepository itemTable;

    public ItemEntityService(ItemEntityRepository itemTable) {

        this.itemTable = itemTable;
    }

    public Item findItemById(int itemId) {

        // Returns item object based on the itemId passed in
        return itemTable.findItemById(itemId);

    }

    // Loads available inventory based on the value of the search bar, no value returns everything
    public List<Item> loadInventory(String search) {

            String pattern = "%" + search + "%";

            return itemTable.inventorySearch(pattern);
    }
}
