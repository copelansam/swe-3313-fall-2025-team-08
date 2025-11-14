package com.example.ecommerce.service;

import com.example.ecommerce.repository.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    private final CardRepository cardTable;

    public CardService(CardRepository cardTable){

        this.cardTable = cardTable;
    }
}
