package com.example.cartservice.entity.promotion;

import com.example.cartservice.entity.cart.Cart;
import com.example.cartservice.entity.item.Item;

import java.util.List;

public abstract class Promotion {
    protected int promotionId;

    public int getPromotionId() {
        return promotionId;
    }

    public abstract double calculateDiscount(Cart cart);
}
