package com.example.cartservice.dto;

import com.example.cartservice.entity.item.Item;

public class DigitalItemDTO extends ItemDTO {
    public DigitalItemDTO(int itemId, int categoryId, int sellerId, double price, int quantity) {
        super(itemId, categoryId, sellerId, price, quantity);
    }

    public DigitalItemDTO(Item item) {
        super(item.getId(), item.getCategoryId(), item.getSellerId(), item.getPrice(), item.getQuantity());
    }
}
