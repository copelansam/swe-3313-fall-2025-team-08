package com.example.ecommerce.controller;


import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.ValidateOrderCredentials;
import com.example.ecommerce.service.OrderEntityService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String processPayment(Model model, HttpSession session,
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

        Cart cart = (Cart) session.getAttribute("cart");

        ValidateOrderCredentials orderInfo = orderEntityService.validateOrderInput(city,state,zip,streetAddress,cardNumber,expirationMonth,expirationYear,securityCode,shippingName,shipping, cart);

        if (!orderInfo.isValid()){

            model.addAttribute("errorMessage",orderInfo.getMessage());

            return "redirect:/payment";

        }

        model.addAttribute("cart",cart);

        model.addAttribute("orderInfo", orderInfo.getOrderInfo());

        return "confirm-order";
    }

    @GetMapping("/confirm")
    public String confirm(){

        return "confirm";
    }

    @PostMapping("/confirm-order")
    public String displayReceipt(Model model, HttpSession session){

        return "receipt";

    }

    @GetMapping("/receipt")
    public String receipt(){
        return "receipt";
    }
}
