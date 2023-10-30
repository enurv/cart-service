package com.example.cartservice.entity.cart;

import com.example.cartservice.Constants;
import com.example.cartservice.entity.item.DefaultItem;
import com.example.cartservice.entity.item.DigitalItem;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.entity.promotion.Promotion;
import com.example.cartservice.exception.MaximumUniqueItemLimitExceededException;
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

}