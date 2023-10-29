package com.example.cartservice.entity.promotion;

import com.example.cartservice.Constants;

public class CategoryPromotion extends Promotion {
    public CategoryPromotion() {
        promotionId = Constants.CATEGORY_SELLER_PROMOTION_ID;
    }

    @Override
    public double getDiscount() {
        return 0;
    }
}
