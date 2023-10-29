package com.example.cartservice.dto;

import com.example.cartservice.entity.item.VasItem;

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

    public VasItemDTO(VasItem vasItem) {
        this.itemId = vasItem.getVasItemId();
        this.vasItemId = vasItem.getVasItemId();
        this.categoryId = vasItem.getCategoryId();
        this.sellerId = vasItem.getSellerId();
        this.price = vasItem.getPrice();
        this.quantity = vasItem.getQuantity();
    }
}
