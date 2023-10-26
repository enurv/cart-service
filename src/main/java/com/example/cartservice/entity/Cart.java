package com.example.cartservice.entity;

import com.example.cartservice.entity.item.Item;
import com.example.cartservice.entity.promotion.Promotion;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item newItem) {
        this.items.stream().filter(item -> item.getId() == newItem.getId()).findAny().ifPresentOrElse(
                item -> item.setQuantity(newItem.getQuantity()),
                () -> this.items.add(newItem)
        );
        System.out.println(items.get(0).toString());
    }

    public void removeItem(Item item) {
    }

    public void resetItems() {
    }

    public List<Item> getCartItems() {
        return null;
    }

    public double getTotalPrice() {
        return 0;
    }

    private void calculateTotalPrice() {
    }


}
