package com.example.cartservice.entity.item;


import com.example.cartservice.Constants;

public class DigitalItem extends Item {

    public DigitalItem(int id, double price, int categoryId, int sellerId, int quantity) {
        super(id, price, categoryId, sellerId, quantity);
        this.maxQuantity = Constants.MAX_DIGITAL_ITEM_QUANTITY;
        this.categoryId = Constants.DIGITAL_ITEM_CATEGORY_ID;
    }
}
