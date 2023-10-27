package com.example.cartservice.factory;

import com.example.cartservice.entity.cart.Cart;
import com.example.cartservice.entity.cart.DefaultItemCart;
import com.example.cartservice.entity.cart.DigitalItemCart;
import org.springframework.stereotype.Component;

import static com.example.cartservice.Constants.DIGITAL_ITEM_CATEGORY_ID;

@Component
public class CartFactory {
    public Cart createCart(int categoryId) {
        if (categoryId == DIGITAL_ITEM_CATEGORY_ID) {
            return new DigitalItemCart();
        } else {
            return new DefaultItemCart();
        }
    }
}
