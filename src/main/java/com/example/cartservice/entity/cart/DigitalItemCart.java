package com.example.cartservice.entity.cart;

import com.example.cartservice.Constants;
import com.example.cartservice.entity.item.DigitalItem;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.exception.NonCompatibleItemTypeException;


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
            throw new NonCompatibleItemTypeException("You are trying to add a default item to a digital item cart.");
        }
    }

    @Override
    public void removeItem(Item item) {

    }

    @Override
    protected void selectPromotion() {

    }


    public boolean isNewItemCompatible(Item item) {
        return item instanceof DigitalItem;
    }
}
