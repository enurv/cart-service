package com.example.cartservice.entity.promotion;

import com.example.cartservice.Constants;

public class SameSellerPromotion extends Promotion {
    public SameSellerPromotion() {
        promotionId = Constants.SAME_SELLER_PROMOTION_ID;
    }

    @Override
    public double getDiscount() {
        return 0;
    }
}
