package com.example.cartservice.entity;

import com.example.cartservice.entity.item.Item;
import com.example.cartservice.entity.promotion.Promotion;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class Cart {
    private final int MAX_ITEM_NUMBER = 30;
    private final int MAX_UNIQUE_ITEM_NUMBER = 10;
    private final int MAX_TOTAL_PRICE = 500000;

    private UUID id;
    private double totalPrice;
    private Promotion promotion;
    private int itemCount;
    private List<Item> items;

    public void addItem(List<Item> items) {}

    public void removeItem(List<Item> items) {}

    public List<Item> getCartItems() {
        return null;
    }

    public int getItemCount() {
        return 0;
    }

    public double getTotalPrice() {
        return 0;
    }

    private void calculateTotalPrice() {}
}
