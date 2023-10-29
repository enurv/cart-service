package com.example.cartservice.entity.promotion;

import com.example.cartservice.Constants;
import com.example.cartservice.entity.cart.Cart;

public class SameSellerPromotion extends Promotion {
    public SameSellerPromotion() {
        promotionId = Constants.SAME_SELLER_PROMOTION_ID;
    }

    @Override
    public double calculateDiscount(Cart cart) {
        return 0;
    }
}
