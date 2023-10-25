package com.example.cartservice.entity.item;

import java.util.UUID;

public abstract class Item {
    protected int maxItemAmount;
    protected int id;
    protected double price;
    protected int categoryId;
    protected int sellerId;
}
