package com.example.cartservice.service.promotion;

import com.example.cartservice.entity.cart.Cart;
import com.example.cartservice.entity.promotion.CategoryPromotion;
import com.example.cartservice.entity.promotion.Promotion;
import com.example.cartservice.entity.promotion.SameSellerPromotion;
import com.example.cartservice.entity.promotion.TotalPricePromotion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionService {
    private final List<Promotion> promotions = new ArrayList<Promotion>();

    public PromotionService() {
        promotions.add(new SameSellerPromotion());
        promotions.add(new CategoryPromotion());
        promotions.add(new TotalPricePromotion());
    }

    public Promotion selectBestPromotion(Cart cart) {
        System.out.println(cart);
        Promotion bestPromotion = null;
        double bestDiscount = 0;
        for (Promotion promotion : promotions) {
            double discount = promotion.calculateDiscount(cart);
            if (discount > bestDiscount) {
                bestDiscount = discount;
                bestPromotion = promotion;
            }
        }
        return bestPromotion;
    }
}
