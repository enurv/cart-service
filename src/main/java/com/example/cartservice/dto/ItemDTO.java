package com.example.cartservice.dto;

public class ItemDTO {
    public int itemId;
    public int categoryId;
    public int sellerId;
    public double price;
    public int quantity;

    public ItemDTO(int itemId, int categoryId, int sellerId, double price, int quantity) {
        this.itemId = itemId;
        this.categoryId = categoryId;
        this.sellerId = sellerId;
        this.price = price;
        this.quantity = quantity;
    }

}
