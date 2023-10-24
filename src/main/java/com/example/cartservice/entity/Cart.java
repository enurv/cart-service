package com.example.cartservice.entity;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class Cart {
    private UUID id;
    private double totalPrice;
    private Promotion promotion;
    private int itemCount;
    private List<Item> items;
}
