package com.example.cartservice.entity.cart;


import com.example.cartservice.Constants;
import com.example.cartservice.entity.item.Item;


public class DefaultItemCart extends Cart {
    @Override
    public void addItem(Item newItem) {

    }

    @Override
    public void removeItem(Item item) {

    }

    @Override
    public boolean isNewItemCompatible(Item item) {
        return item.getCategoryId() != Constants.DIGITAL_ITEM_CATEGORY_ID;
    }
}
