package com.example.cartservice.entity.promotion;

import com.example.cartservice.Constants;
import com.example.cartservice.entity.cart.Cart;

public class TotalPricePromotion extends Promotion {
    public TotalPricePromotion() {
        promotionId = Constants.TOTAL_PRICE_PROMOTION_ID;
    }

    @Override
    public double calculateDiscount(Cart cart) {
        double totalPrice = cart.getTotalPrice();
        if (totalPrice < 5000) {
            return 250;
        } else if (totalPrice < 10000) {
            return 500;
        } else if (totalPrice < 50000) {
            return 1000;
        } else {
            return 2000;
        }
    }
}
