package com.example.ecommerce.controller;


import com.example.ecommerce.model.Item;
import com.example.ecommerce.service.ItemEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class MenuBarPageController {

    public final ItemEntityService itemEntityService;

    MenuBarPageController(ItemEntityService itemEntityService){

        this.itemEntityService = itemEntityService;
    }

    @GetMapping("/browse")
    public String mainPage(Model model){

        return "browse";
    }

    @GetMapping("/search")
    public String search(){

        return "search";
    }

    @GetMapping("/account")
    public String account(){

        return "account";
    }
}
