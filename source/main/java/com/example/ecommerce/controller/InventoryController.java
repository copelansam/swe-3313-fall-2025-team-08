package com.example.ecommerce.controller;

import com.example.ecommerce.model.Item;
import com.example.ecommerce.service.ItemEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InventoryController {

    public final ItemEntityService itemEntityService;

    public InventoryController(ItemEntityService itemEntityService){

        this.itemEntityService = itemEntityService;
    }

    @RequestMapping(value = "/browse", method = {RequestMethod.GET,RequestMethod.POST})
    public String browse(@RequestParam(required = false, defaultValue = "") String search, Model model) {

        List<Item> items = itemEntityService.loadInventory(search);

        model.addAttribute("items",items);

        return "browse";
    }
}
