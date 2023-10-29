package com.example.cartservice.entity.promotion;

import com.example.cartservice.Constants;

public class TotalPricePromotion extends Promotion {
    public TotalPricePromotion() {
        promotionId = Constants.TOTAL_PRICE_PROMOTION_ID;
    }

    @Override
    public double getDiscount() {
        return 0;
    }
}
