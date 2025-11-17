package com.example.ecommerce.service;

import com.example.ecommerce.repository.CardEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    private final CardEntityRepository cardTable;

    public CardService(CardEntityRepository cardTable){

        this.cardTable = cardTable;
    }
}
