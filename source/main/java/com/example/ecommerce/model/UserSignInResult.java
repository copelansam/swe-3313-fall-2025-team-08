package com.example.ecommerce.model;

public class UserSignInResult {

    private boolean success;

    private String message;

    private User user;

    public UserSignInResult(boolean success,String message){

        this.success = success;

        this.message = message;

        this.user = null;
    }

    public UserSignInResult(boolean success, String message, User user){

        this.success = success;

        this.message = message;

        this.user = user;
    }

    public boolean getSuccess(){

        return this.success;
    }

    public String getMessage(){

        return this.message;
    }

    public User getUser(){

        return this.user;
    }
}
