package com.example.cartservice.entity.cart;

import com.example.cartservice.Constants;
import com.example.cartservice.entity.item.DefaultItem;
import com.example.cartservice.entity.item.DigitalItem;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.entity.promotion.Promotion;
import com.example.cartservice.entity.promotion.TotalPricePromotion;
import com.example.cartservice.exception.MaximumUniqueItemLimitExceededException;
import com.example.cartservice.service.promotion.PromotionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class DigitalItemCartTest {
    private DigitalItemCart digitalItemCart;
    @Mock
    private PromotionService promotionServiceMock;

    @Mock
    private Promotion promotionMock;


    @BeforeEach
    public void setUp() {
        Mockito.when(promotionMock.calculateDiscount(Mockito.any(Cart.class))).thenReturn(5.0);
        Mockito.when(promotionServiceMock.selectBestPromotion(Mockito.any(Cart.class))).thenReturn(promotionMock);
        digitalItemCart = new DigitalItemCart(promotionServiceMock);
    }

    @Test
    public void removeExistingItem() {
        //given
        Item digitalItem = new DigitalItem(1, 10, 1000, 2221, 3);
        digitalItemCart.addItem(digitalItem);

        //when
        digitalItemCart.removeItem(digitalItem.getId());

        //then
        assertEquals(0, digitalItemCart.getItems().size());
        assertEquals(0, digitalItemCart.getTotalPrice());
        assertEquals(0, digitalItemCart.getFinalPrice());

    }

    @Test
    public void throwErrorWhenMaxUniqueItemLimitExceeded() {
        //given
        int maxUniqueItemNumber = Constants.MAX_UNIQUE_ITEM_NUMBER;
        for (int i = 0; i < maxUniqueItemNumber; i++) {
            Item item = new DigitalItem(i, 10, 1000, 1000, 1);
            digitalItemCart.addItem(item);
        }

        //when
        Item item = new DigitalItem(maxUniqueItemNumber + 1, 10, 1000, 1000, 1);
        Throwable thrown = assertThrows(MaximumUniqueItemLimitExceededException.class, () -> digitalItemCart.addItem(item));

        //then
        assertEquals("You cannot add more than " + maxUniqueItemNumber + " unique items.", thrown.getMessage());
    }

}