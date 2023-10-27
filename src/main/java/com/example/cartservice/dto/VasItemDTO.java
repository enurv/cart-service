package com.example.cartservice.dto;

public class VasItemDTO extends ItemDTO {
    public int vasItemId;

    public VasItemDTO(int itemId, int vasItemId, int categoryId, int sellerId, double price, int quantity) {
        super(itemId, categoryId, sellerId, price, quantity);
        this.vasItemId = vasItemId;
    }
}
