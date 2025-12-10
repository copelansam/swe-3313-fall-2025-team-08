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

    // Model Attribute annotation makes it  so that  the cart is available in all views rendered by this controller
    @ModelAttribute("cart")
    public Cart cart(){

        return new Cart();
    }

    // Load the page that will display the cart and its items
    @GetMapping("/cart")
    public String viewCart(@ModelAttribute("cart") Cart cart, RedirectAttributes redirectAttributes){

        if (cart.getItems().isEmpty()){

            redirectAttributes.addFlashAttribute("errorMessage","Cart is empty. Please add items to your cart");


            return "redirect:/browse";
        }


        return "cart";
    }

    // Add item to cart, display message regarding if the item was added
    @PostMapping("/addToCart")
    public String addItem(@ModelAttribute("cart") Cart cart, @RequestParam int itemId, RedirectAttributes redirectAttributes){

        Item adding = itemEntityService.findItemById(itemId);

        if (cart.itemPresentInCart(adding.getItemId())){

            redirectAttributes.addFlashAttribute("errorMessage",adding.getName() + " is already in the cart.");

            return "redirect:/browse";
        }

        cart.addItem(adding);

        redirectAttributes.addFlashAttribute("successMessage",adding.getName() + " Successfully Added to Cart");

        return "redirect:/browse";
    }

    // Remove an item from the cart
    @PostMapping("/removeItemFromCart")
    public String removeItem(@ModelAttribute("cart") Cart cart, @RequestParam int itemId, RedirectAttributes redirectAttributes){

        cart.removeItemById(itemId);

        // Return user to inventory screen if their cart becomes empty
        if (cart.getItems().isEmpty()){

            redirectAttributes.addFlashAttribute("errorMessage","Cart became empty. " +
                    "Redirected back to main page. Please add items to your cart");

            return "redirect:/browse";
        }

        return "redirect:/cart";
    }
}
