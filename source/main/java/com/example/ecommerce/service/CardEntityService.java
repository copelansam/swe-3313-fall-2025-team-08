package com.example.ecommerce.service;

import com.example.ecommerce.repository.CardEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class CardEntityService {

    private final CardEntityRepository cardTable;

    public CardEntityService(CardEntityRepository cardTable){

        this.cardTable = cardTable;
    }
}
