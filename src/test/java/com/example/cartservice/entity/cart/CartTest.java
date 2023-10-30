package com.example.cartservice.entity.cart;

import com.example.cartservice.entity.item.DigitalItem;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.entity.promotion.Promotion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private Cart cart;
    @Mock
    private Promotion promotion;

    @BeforeEach
    public void setUp() {
        cart = new Cart() {
            @Override
            public void addItem(Item newItem) {
            }

            @Override
            protected void calculateDiscount() {
            }

            @Override
            protected void calculateTotalPrice() {
            }
        };
    }

    @Test
    public void setFinalPriceWithZeroPrice() {
        //given
        cart.totalPrice = 0;
        cart.totalDiscount = 5;

        //when
        cart.setFinalPrice();

        //then
        assertEquals(0, cart.finalPrice);
    }

    @Test
    public void setFinalPrice() {
        //given
        cart.totalPrice = 10;
        cart.totalDiscount = 5;

        //when
        cart.setFinalPrice();

        //then
        assertEquals(5, cart.finalPrice);
    }

    @Test
    public void removeExistingItem() {
        //given
        Item digitalItem = new DigitalItem(1, 10, 1000, 2221, 3);
        cart.addItem(digitalItem);

        //when
        cart.removeItem(digitalItem.getId());

        //then
        assertEquals(0, cart.getItems().size());
        assertEquals(0, cart.getTotalPrice());
        assertEquals(0, cart.getTotalDiscount());
        assertEquals(0, cart.getFinalPrice());

    }

}