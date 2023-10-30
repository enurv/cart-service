package com.example.cartservice.entity.cart;

import com.example.cartservice.entity.item.DigitalItem;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.entity.promotion.Promotion;
import com.example.cartservice.service.promotion.PromotionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class DigitalItemCartTest {
    private DigitalItemCart digitalItemCart;
    @Mock
    private PromotionService promotionServiceMock;

    @Mock
    Promotion mockPromotion;

    @BeforeEach
    public void setUp() {
        Mockito.when(mockPromotion.calculateDiscount(Mockito.any(DigitalItemCart.class))).thenReturn(5.0);
        promotionServiceMock = Mockito.mock(PromotionService.class).when(promotionServiceMock.selectBestPromotion(Mockito.any(DigitalItemCart.class))).thenReturn(mockPromotion);
        digitalItemCart = new DigitalItemCart(promotionServiceMock);
    }


}