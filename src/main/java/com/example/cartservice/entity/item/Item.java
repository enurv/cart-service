package com.example.cartservice.entity.item;

import com.example.cartservice.Constants;
import com.example.cartservice.exception.MaximumItemLimitExceededException;

public abstract class Item {
    protected int maxQuantity = Constants.MAX_ITEM_QUANTITY;
    protected int itemId;
    protected double price;
    protected int categoryId;
    protected int sellerId;
    protected int quantity;

    public Item(int itemId, double price, int categoryId, int sellerId) {
        this.itemId = itemId;
        this.price = price;
        this.categoryId = categoryId;
        this.sellerId = sellerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setQuantity(int quantity) {
        if (quantity > maxQuantity) {
            throw new MaximumItemLimitExceededException("You cannot add more than " + maxQuantity + " of the same item.");
        }
        this.quantity = quantity;
    }

    public int getId() {
        return itemId;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
