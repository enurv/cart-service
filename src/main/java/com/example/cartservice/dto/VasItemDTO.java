package com.example.cartservice.dto;

public class VasItemDTO {
    public int itemId;
    public int vasItemId;
    public int categoryId;
    public int sellerId;
    public double price;
    public int quantity;


    public VasItemDTO(int itemId, int vasItemId, int categoryId, int sellerId, double price, int quantity) {
        this.itemId = itemId;
        this.vasItemId = vasItemId;
        this.categoryId = categoryId;
        this.sellerId = sellerId;
        this.price = price;
        this.quantity = quantity;
    }
}
