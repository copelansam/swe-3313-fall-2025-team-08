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

    public InventoryCreationResult verifyItem(String name, String description, String price, MultipartFile image){

        boolean success = false;

        String message =" ";

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

            try{

                final String UPLOAD_DIRECTORY = "uploads/";

                String imageName = Paths.get(image.getOriginalFilename()).getFileName().toString();

                Path uploadPath = Paths.get("uploads");

                Path filePath = uploadPath.resolve(imageName);

                Files.copy(image.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);
            }
            catch (Exception e){
                throw new RuntimeException("Failed to save image", e);
            }

            itemTable.addRow(name,description,image.getOriginalFilename(),new BigDecimal(price),true);

            message = "Item successfully added to inventory!";

            success = true;
        }
        return new InventoryCreationResult(success, message);
    }
}
