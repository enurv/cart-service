package com.example.cartservice.dto;

import java.util.List;

public class CartDTO {
    public double totalPrice;
    public int appliedPromotionId;

    public CartDTO(double totalPrice, int appliedPromotionId, double totalDiscount) {
        this.totalPrice = totalPrice;
        this.appliedPromotionId = appliedPromotionId;
        this.totalDiscount = totalDiscount;
    }

    public double totalDiscount;

}
