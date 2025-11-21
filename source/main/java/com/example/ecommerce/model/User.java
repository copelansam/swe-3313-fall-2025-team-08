package com.example.ecommerce.model;

public class User {

    private String name;

    private String username;

    private String email;

    private boolean isAdmin;

    public User(String name, String username, String email){

        this.name = name;

        this.username = username;

        this.email = email;

        isAdmin = false;
    }

    public String getName(){

        return this.name;
    }

    public String getUsername(){

        return this.username;
    }

    public String getEmail(){

        return this.email;
    }
}
