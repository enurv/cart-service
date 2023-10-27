package com.example.cartservice.entity.cart;

import com.example.cartservice.entity.item.Item;
import com.example.cartservice.entity.promotion.Promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Cart {
    private final int MAX_ITEM_NUMBER = 30;
    private final int MAX_UNIQUE_ITEM_NUMBER = 10;
    private final int MAX_TOTAL_PRICE = 500000;

    private UUID id;
    private double totalPrice;
    private Promotion promotion;
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item newItem) {
        if (isNewItemCompatible(newItem)) {
            Item existingItem = findItemById(newItem.getId());
            if (existingItem != null) {
                addExistingItem(existingItem, newItem);
            } else {
                addNewItem(newItem);
            }
        } else {
            //TO-DO: throw error
            System.out.println("Item is not compatible");
        }
    }

    private void addExistingItem(Item existingItem, Item newItem) {
        if (items.stream().reduce(0, (subtotal, element) -> subtotal + element.getQuantity(), Integer::sum) + newItem.getQuantity() > MAX_ITEM_NUMBER) {
            //TO-DO: throw error
            System.out.println("Max item number reached");
        } else {
            existingItem.setQuantity(newItem.getQuantity() + existingItem.getQuantity());
        }
    }

    private void addNewItem(Item newItem) {
        if (items.size() >= MAX_UNIQUE_ITEM_NUMBER) {
            //TO-DO: throw error
            System.out.println("Max unique item number reached");
        } else {
            items.add(newItem);
        }
    }

    private Item findItemById(int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void removeItem(Item item) {
    }


    public List<Item> getCartItems() {
        return null;
    }

    public double getTotalPrice() {
        return 0;
    }

    private void calculateTotalPrice() {
    }

    public abstract boolean isNewItemCompatible(Item item);


}
