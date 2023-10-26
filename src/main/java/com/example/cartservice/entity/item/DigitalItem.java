package com.example.cartservice.entity.item;

public class DigitalItem extends Item {

    public DigitalItem(int id, double price, int categoryId, int sellerId, int quantity) {
        super(id, price, categoryId, sellerId, quantity);
        this.maxQuantity = 5;
        this.categoryId = 7889;
    }
}
