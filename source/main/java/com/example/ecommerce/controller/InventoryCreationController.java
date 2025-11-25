package com.example.ecommerce.controller;

import com.example.ecommerce.model.InventoryCreationResult;
import com.example.ecommerce.service.InventoryCreationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InventoryCreationController {

    private final InventoryCreationService inventoryCreationService;

    public InventoryCreationController(InventoryCreationService inventoryCreationService){

        this.inventoryCreationService = inventoryCreationService;
    }

    @GetMapping("/add-inventory")
    public String displayPage(){

        return "add-inventory";
    }

    @PostMapping("/create-inventory")
    public String addItem(@RequestParam("name") String name,
                          @RequestParam("description") String description,
                          @RequestParam("price") String price,
                          @RequestParam("fileName") MultipartFile image,
                          RedirectAttributes redirectAttributes){

        InventoryCreationResult result = inventoryCreationService.verifyItem(name,description,price,image);

        redirectAttributes.addFlashAttribute("inventoryMessage", result.getMessage());

        return "redirect:/add-inventory";
    }
}
