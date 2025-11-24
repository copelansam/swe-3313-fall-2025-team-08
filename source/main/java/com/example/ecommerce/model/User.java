package com.example.ecommerce.model;

public class User {

    private String name;

    private String username;

    private String email;

    private boolean isAdmin;

    public User(String name, String username, String email, boolean isAdmin){

        this.name = name;

        this.username = username;

        this.email = email;

        this.isAdmin = isAdmin;
    }

    public User(){}

    public void setName(String name){

        this.name = name;
    }

    public String getName(){

        return this.name;
    }

    public String getUsername(){

        return this.username;
    }

    public void setUsername(String username){

        this.username = username;
    }

    public String getEmail(){

        return this.email;
    }

    public boolean getIsAdmin(){

        return this.isAdmin;
    }
}
