package com.example.cartservice.entity.item;

public abstract class Item {
    protected int maxQuantity;
    protected int id;
    protected double price;
    protected int categoryId;
    protected int sellerId;
    protected int quantity;

    public Item(int id, double price, int categoryId, int sellerId, int quantity) {
        this.id = id;
        this.price = price;
        this.categoryId = categoryId;
        this.sellerId = sellerId;
        this.quantity = quantity;
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
            //TO-DO: throw error
        }
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
