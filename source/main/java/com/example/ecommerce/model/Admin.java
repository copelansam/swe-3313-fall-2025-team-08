package com.example.ecommerce.model;

public class Admin extends User{

    public Admin(int userId, String name, String username, String email) {

        super(userId,name, username, email, true);
    }
}
