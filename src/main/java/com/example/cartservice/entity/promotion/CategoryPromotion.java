package com.example.cartservice.entity.promotion;

import com.example.cartservice.Constants;
import com.example.cartservice.entity.cart.Cart;
import com.example.cartservice.entity.item.Item;

import java.util.List;

public class CategoryPromotion extends Promotion {
    public CategoryPromotion() {
        promotionId = Constants.CATEGORY_SELLER_PROMOTION_ID;
    }

    @Override
    public double calculateDiscount(Cart cart) {
        double totalAmount = 0.0;
        List<Item> items = cart.getItems();
        for (Item item : items) {
            if (item.getCategoryId() == (Constants.CATEGORY_SELLER_PROMOTION_CATEGORY_ID)) {
                totalAmount += item.getPrice() * item.getQuantity();
            }
        }

        return totalAmount * Constants.CATEGORY_SELLER_PROMOTION_DISCOUNT_RATE;
    }
}
