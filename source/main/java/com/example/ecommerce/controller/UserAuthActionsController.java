package com.example.ecommerce.controller;

import com.example.ecommerce.model.UserRegistrationResult;
import com.example.ecommerce.model.UserSignInResult;
import com.example.ecommerce.service.UserEntityService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserAuthActionsController {

    public final UserEntityService userEntityService;

    UserAuthActionsController(UserEntityService userEntityService){

        this.userEntityService = userEntityService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        UserSignInResult signIn = userEntityService.signIn(username, password);

        if (!signIn.getSuccess()){

            model.addAttribute("errorMessage",signIn.getMessage());

            return "login";
        }

        session.setAttribute("userSession",signIn.getUser());

        return "redirect:/browse";

    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("name") String name,
                               @RequestParam("email") String email,
                               @RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("confirmPassword") String confirmPassword,
                               HttpSession session,
                               Model model) {

        UserRegistrationResult registerUser = userEntityService.registerUser(name, username, email, password, confirmPassword);

        if (!registerUser.getSuccess()) {

            model.addAttribute("errorMessage", registerUser.getMessage());

            return "create-account";
        }

        session.setAttribute("userSession", registerUser.getUser());

        return "redirect:/browse";
    }
}
