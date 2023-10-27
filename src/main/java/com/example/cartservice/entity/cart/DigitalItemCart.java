package com.example.cartservice.entity.cart;

import com.example.cartservice.Constants;
import com.example.cartservice.entity.item.DigitalItem;
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


    public boolean isNewItemCompatible(Item item) {
        return item instanceof DigitalItem;
    }
}
