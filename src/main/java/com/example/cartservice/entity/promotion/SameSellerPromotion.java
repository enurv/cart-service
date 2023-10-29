package com.example.cartservice.entity.promotion;

import com.example.cartservice.Constants;
import com.example.cartservice.entity.item.Item;

import java.util.List;

public class SameSellerPromotion extends Promotion {
    public SameSellerPromotion() {
        promotionId = Constants.SAME_SELLER_PROMOTION_ID;
    }

    @Override
    public double calculateDiscount(List<Item> items) {
        return 0;
    }
}
