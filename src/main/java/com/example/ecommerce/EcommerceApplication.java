package com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;
import java.awt.*;

@SpringBootApplication
public class EcommerceApplication {
    public static void main(String[] args){
        SpringApplication.run(EcommerceApplication.class,args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void openBrowser(){
        try{
            String url = "http://localhost:8080";
            if (Desktop.isDesktopSupported()){
                Desktop.getDesktop().browse(new URI(url));
            }
        }
        catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
