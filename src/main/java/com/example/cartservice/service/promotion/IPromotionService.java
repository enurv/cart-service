package com.example.cartservice.service.promotion;

import com.example.cartservice.entity.cart.Cart;
import com.example.cartservice.entity.promotion.Promotion;

public interface IPromotionService {
    Promotion selectBestPromotion(Cart cart);
}
