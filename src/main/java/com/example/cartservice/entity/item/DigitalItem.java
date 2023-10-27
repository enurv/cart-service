package com.example.cartservice.entity.item;

import static com.example.cartservice.Constants.DIGITAL_ITEM_CATEGORY_ID;

public class DigitalItem extends Item {

    public DigitalItem(int id, double price, int categoryId, int sellerId, int quantity) {
        super(id, price, categoryId, sellerId, quantity);
        this.maxQuantity = 5;
        this.categoryId = DIGITAL_ITEM_CATEGORY_ID;
    }
}
