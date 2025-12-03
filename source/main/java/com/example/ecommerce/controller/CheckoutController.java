package com.example.ecommerce.controller;


import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.OrderInfo;
import com.example.ecommerce.model.User;
import com.example.ecommerce.model.ValidateOrderCredentials;
import com.example.ecommerce.service.OrderEntityService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
public class CheckoutController {

    private final OrderEntityService orderEntityService;

    public CheckoutController(OrderEntityService orderEntityService){

        this.orderEntityService = orderEntityService;
    }



    @GetMapping("/payment")
    public String payment(Model model, HttpSession session){

        Cart cart = (Cart) session.getAttribute("cart");

        model.addAttribute("cart", cart);

        return "payment";
    }

    @PostMapping("/process-payment")
    public String processPayment(Model model, HttpSession session, RedirectAttributes redirectAttributes,
                                 @RequestParam("name") String shippingName,
                                 @RequestParam("street") String streetAddress,
                                 @RequestParam("city") String city,
                                 @RequestParam("state") String state,
                                 @RequestParam("zip") String zip,
                                 @RequestParam("shipping") String shipping,
                                 @RequestParam("cardNumber") String cardNumber,
                                 @RequestParam("expirationMonth") String expirationMonth,
                                 @RequestParam("expirationYear") String expirationYear,
                                 @RequestParam("securityCode") String securityCode){

        // validate user input based on our requirements and perform necessary action
        Cart cart = (Cart) session.getAttribute("cart");

        User user = (User) session.getAttribute("userSession");

        ValidateOrderCredentials orderInfo = orderEntityService.validateOrderInput(city,state,zip,streetAddress,cardNumber,expirationMonth,expirationYear,securityCode,shippingName,shipping, cart, user.getUserId());

        // display message if there is an issue with user input
        if (!orderInfo.isValid()){

            redirectAttributes.addFlashAttribute("errorMessage",orderInfo.getMessage());

            return "redirect:/payment";

        }

        // store user input and wait until they confirm the order
        model.addAttribute("cart",cart);

        session.setAttribute("orderInfo",orderInfo.getOrderInfo());

        model.addAttribute("orderInfo", orderInfo.getOrderInfo());

        return "confirm-order";
    }

    @PostMapping("/confirm-order")
    public String displayReceipt(Model model, HttpSession session){

        // retrieve all information relevant to the receipt and display it

        OrderInfo orderInfo = (OrderInfo) session.getAttribute("orderInfo");

        Cart cart = (Cart) session.getAttribute("cart");

        User user = (User) session.getAttribute("userSession");

        orderInfo.setOrderId(orderEntityService.createOrder(orderInfo,cart));

        Cart cartCopy = new Cart();

        cartCopy.setItems(new ArrayList<>(cart.getItems()));



        model.addAttribute("cart",cartCopy);

        model.addAttribute("orderInfo",orderInfo);

        model.addAttribute("user",user);

        cart.clear();

        session.setAttribute("cart",cart);

        return "receipt";

    }
}
