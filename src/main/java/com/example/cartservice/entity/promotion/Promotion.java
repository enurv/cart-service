package com.example.cartservice.entity.promotion;

public abstract class Promotion {
    protected int promotionId;

    public int getPromotionId() {
        return promotionId;
    }

    public abstract double getDiscount();
}
