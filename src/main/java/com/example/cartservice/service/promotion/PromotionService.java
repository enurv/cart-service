package com.example.cartservice.service.promotion;

import com.example.cartservice.entity.cart.Cart;
import com.example.cartservice.entity.promotion.Promotion;
import org.springframework.stereotype.Service;

@Service
public class PromotionService implements IPromotionService {
    @Override
    public Promotion selectBestPromotion(Cart cart) {
        return null;
    }
}
