package com.example.cartservice.entity.cart;

import com.example.cartservice.entity.item.Item;

import static com.example.cartservice.Constants.DIGITAL_ITEM_CATEGORY_ID;

public class DigitalCart extends Cart {
    @Override
    public boolean isNewItemCompatible(Item item) {
        return item.getCategoryId() == DIGITAL_ITEM_CATEGORY_ID;
    }
}
