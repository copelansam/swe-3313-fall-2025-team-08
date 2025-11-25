package com.example.ecommerce.model;

public class InventoryCreationResult {

    private boolean success;

    private String message;

    public InventoryCreationResult(boolean success, String message){

        this.message = message;

        this.success = success;
    }

    public String getMessage(){
        return this.message;
    }
}
