package com.example.cartservice.service.promotion;

import org.springframework.stereotype.Component;

@Component
public class PromotionServiceProvider {
    private static IPromotionService promotionService;

    public PromotionServiceProvider(PromotionService promotionService) {
        PromotionServiceProvider.promotionService = promotionService;
    }

    public static IPromotionService getPromotionService() {
        return promotionService;
    }
}
