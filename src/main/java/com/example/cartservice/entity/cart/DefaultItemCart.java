package com.example.cartservice.entity.cart;


import com.example.cartservice.Constants;
import com.example.cartservice.entity.item.DefaultItem;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.entity.item.VasItem;


public class DefaultItemCart extends Cart {
    @Override
    public void addItem(Item newItem) {
        if (newItem instanceof DefaultItem) {
            addDefaultItem((DefaultItem) newItem);
        } else if (newItem instanceof VasItem) {
            addVasItem((VasItem) newItem);
        } else {
            //TO-DO: throw error
            System.out.println("Item is not compatible");
        }
    }

    public void addDefaultItem(DefaultItem newDefaultItem) {
        Item existingItem = findItemById(newDefaultItem.getId());
        if (existingItem != null) {
            addExistingItem(existingItem, newDefaultItem);
        } else {
            addNewItem(newDefaultItem);
        }
    }

    public void addVasItem(VasItem newVasItem) {

    }
    
    @Override
    public void removeItem(Item item) {

    }

}
