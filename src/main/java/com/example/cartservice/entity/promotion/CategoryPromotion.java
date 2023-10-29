package com.example.cartservice.entity.promotion;

import com.example.cartservice.Constants;
import com.example.cartservice.entity.cart.Cart;

public class CategoryPromotion extends Promotion {
    public CategoryPromotion() {
        promotionId = Constants.CATEGORY_SELLER_PROMOTION_ID;
    }

    @Override
    public double calculateDiscount(Cart cart) {
        return 0;
    }
}
