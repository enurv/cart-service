package com.example.cartservice.entity.item;

public class VasItem extends Item {
    public VasItem(int id, double price, int categoryId, int sellerId, int quantity) {
        super(id, price, categoryId, sellerId, quantity);
        this.maxQuantity = 10;
        this.categoryId = 3242;
        this.sellerId = 5003;
    }
}
