package com.example.cartservice.factory;

import com.example.cartservice.Constants;
import com.example.cartservice.entity.cart.Cart;
import com.example.cartservice.entity.cart.DefaultItemCart;
import com.example.cartservice.entity.cart.DigitalItemCart;
import org.springframework.stereotype.Component;


@Component
public class CartFactory {
    public Cart createCart(int categoryId) {
        if (categoryId == Constants.DIGITAL_ITEM_CATEGORY_ID) {
            return new DigitalItemCart();
        } else {
            return new DefaultItemCart();
        }
    }
}
