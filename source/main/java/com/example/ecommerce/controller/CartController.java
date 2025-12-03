package com.example.ecommerce.controller;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.Item;
import com.example.ecommerce.service.ItemEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String viewCart(@ModelAttribute("cart") Cart cart, RedirectAttributes redirectAttributes){

        if (cart.getItems().isEmpty()){

            redirectAttributes.addFlashAttribute("errorMessage","Cart is empty. Please add items to your cart");


            return "redirect:/browse";
        }


        return "cart";
    }

    @PostMapping("/addToCart")
    public String addItem(@ModelAttribute("cart") Cart cart, @RequestParam int itemId, RedirectAttributes redirectAttributes){

        if (cart.itemPresentInCart(itemId)){

            redirectAttributes.addFlashAttribute("errorMessage","Item is already in cart");

            return "redirect:/browse";
        }

        Item adding = itemEntityService.findItemById(itemId);

        cart.addItem(adding);

        redirectAttributes.addFlashAttribute("successMessage",adding.getName() + " Successfully Added to Cart");

        return "redirect:/browse";
    }

    @PostMapping("/removeItemFromCart")
    public String removeItem(@ModelAttribute("cart") Cart cart, @RequestParam int itemId, RedirectAttributes redirectAttributes){

        cart.removeItemById(itemId);

        // return user to inventory screen if their cart becomes empty
        if (cart.getItems().isEmpty()){

            redirectAttributes.addFlashAttribute("errorMessage","Cart became empty. Redirected back to main page. Please add items to your cart");

            return "redirect:/browse";
        }

        return "redirect:/cart";
    }
}
