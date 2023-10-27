package com.example.cartservice.entity.cart;

import com.example.cartservice.Constants;
import com.example.cartservice.entity.item.Item;


public class DigitalItemCart extends Cart {
    @Override
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

    @Override
    public void removeItem(Item item) {

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

    @Override
    public boolean isNewItemCompatible(Item item) {
        return item.getCategoryId() == Constants.DIGITAL_ITEM_CATEGORY_ID;
    }
}
