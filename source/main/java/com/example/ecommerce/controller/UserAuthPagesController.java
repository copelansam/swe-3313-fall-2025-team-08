package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.model.UserRegistrationResult;
import com.example.ecommerce.model.UserSignInResult;
import com.example.ecommerce.service.UserEntityService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


// Passes the create account screen to the view
@Controller
public class UserAuthPagesController {

    // injects the user service
    public final UserEntityService userEntityService;

    // constructor for dependency injection
    public UserAuthPagesController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    // directs the system to display the sign in screen
    @GetMapping("/")
    public String signIn(Model model) {
        //User userSession = new User();
        return "login";
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

        return "redirect:/main";

    }


    // directs the system to display the create account screen
    @GetMapping("/create-account")
    public String signUp() {

        return "create-account";
    }

    @PostMapping("register")
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

        return "redirect:/main";
    }

    @RequestMapping(value = "/log-out", method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
