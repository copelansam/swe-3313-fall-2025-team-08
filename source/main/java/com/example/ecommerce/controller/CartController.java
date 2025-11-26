package com.example.ecommerce.controller;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.Item;
import com.example.ecommerce.service.ItemEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("cart")
public class CartController {

    private final ItemEntityService itemEntityService;

    public CartController(ItemEntityService itemEntityService){
        this.itemEntityService = itemEntityService;
    }

    @ModelAttribute("cart")
    public Cart cart(){

        return new Cart();
    }

    @GetMapping("/cart")
    public String viewCart(@ModelAttribute("cart") Cart cart, Model model){

        if (cart.getItems().isEmpty()){

            return "redirect:/browse";
        }


        return "cart";
    }

    @PostMapping("/addToCart")
    public String addItem(@ModelAttribute("cart") Cart cart, @RequestParam int itemId){

        if (cart.itemPresentInCart(itemId)){

            return "redirect:/browse";
        }

        cart.addItem(itemEntityService.findItemById(itemId));

        return "redirect:/browse";
    }

    @PostMapping("/removeItemFromCart")
    public String removeItem(@ModelAttribute("cart") Cart cart, @RequestParam int itemId){

        cart.removeItemById(itemId);

        if (cart.getItems().isEmpty()){

            return "redirect:/browse";
        }

        return "redirect:/cart";
    }
}
