package com.example.cartservice.entity.promotion;

import com.example.cartservice.Constants;
import com.example.cartservice.entity.cart.Cart;

public class TotalPricePromotion extends Promotion {
    public TotalPricePromotion() {
        promotionId = Constants.TOTAL_PRICE_PROMOTION_ID;
    }

    @Override
    public double calculateDiscount(Cart cart) {
        return 0;
    }
}
