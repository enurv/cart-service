package com.example.cartservice.entity.promotion;

import com.example.cartservice.Constants;
import com.example.cartservice.entity.cart.Cart;
import com.example.cartservice.entity.item.Item;

import java.util.List;

public class SameSellerPromotion extends Promotion {
    public SameSellerPromotion() {
        promotionId = Constants.SAME_SELLER_PROMOTION_ID;
    }

    @Override
    public double calculateDiscount(Cart cart) {
        if (!itemsFromSameSellerId(cart.getItems())) {
            return 0;
        } else {
            return cart.getTotalPrice() * Constants.SAME_SELLER_PROMOTION_DISCOUNT_RATE;
        }
    }

    public boolean itemsFromSameSellerId(List<Item> items) {
        if (items.size() == 1 && items.get(0).getQuantity() > 1) {
            return true;
        } else if (items.size() > 1) {
            int firstSellerId = items.get(0).getSellerId();

            return items.stream()
                    .map(Item::getSellerId)
                    .allMatch(sellerId -> sellerId.equals(firstSellerId));
        } else {
            return false;
        }


    }
}
