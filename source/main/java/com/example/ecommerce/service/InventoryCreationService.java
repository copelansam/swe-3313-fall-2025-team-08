package com.example.ecommerce.service;


import com.example.ecommerce.model.InventoryCreationResult;
import com.example.ecommerce.repository.ItemEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class InventoryCreationService {

    private final ItemEntityRepository itemTable;

    public InventoryCreationService(ItemEntityRepository itemTable){

        this.itemTable = itemTable;
    }

    // attempt to create new inventory item based on user input
    public InventoryCreationResult verifyItem(String name, String description, String price, MultipartFile image){

        boolean success = false;

        String message = " ";

        // validate user input, if there is an issue create a message to display
        try{
            BigDecimal priceValue = new BigDecimal(price);
        }
        catch (Exception e){

            message = "Price must be a number";

            return new InventoryCreationResult(success,message);
        }

        if (name.isEmpty() || description.isEmpty() || price.isEmpty() || image.isEmpty()){

            message = "Please make sure that all fields are filled out";
        }
        else if (name.length() > 100){

            message = "Max character length for name field is 100 characters";
        }
        else if (description.length() > 1000){
            message = "Max character length for description field is 1000 characters";
        }
        else if (image.getOriginalFilename().length() > 50){
            message = "Max character length for file name is 50 characters";
        }
        else{

            // if the user input is good, create a new item and save the image to the uploads folder
            try{

                final String UPLOAD_DIRECTORY = "uploads/";

                // Retrieves the name of the file the user uploads
                String imageName = Paths.get(image.getOriginalFilename()).getFileName().toString(); // Written by ChatGPT

                // Retrieves the file path to the uploads folder
                Path uploadPath = Paths.get("uploads"); // Written by ChatGPT

                if (!Files.exists(uploadPath)){ // Written by ChatGPT

                    Files.createDirectories(uploadPath);

                }

                Path filePath = uploadPath.resolve(imageName); // Written by ChatGPT

                Files.copy(image.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING); // Written by ChatGPT
            }
            catch (Exception e){
                throw new RuntimeException("Failed to save image", e);
            }

            // Add item to available inventory in database
            itemTable.addRow(name,description,image.getOriginalFilename(),new BigDecimal(price),true);

            message = "Item successfully added to inventory!";

            success = true;
        }
        return new InventoryCreationResult(success, message);
    }
}
