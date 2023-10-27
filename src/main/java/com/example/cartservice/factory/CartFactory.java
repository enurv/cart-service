package com.example.cartservice.factory;

import com.example.cartservice.entity.cart.Cart;
import com.example.cartservice.entity.cart.DefaultCart;
import com.example.cartservice.entity.cart.DigitalCart;
import com.example.cartservice.entity.item.DefaultItem;
import com.example.cartservice.entity.item.DigitalItem;
import org.springframework.stereotype.Component;

import static com.example.cartservice.Constants.DIGITAL_ITEM_CATEGORY_ID;

@Component
public class CartFactory {
    public Cart createCart(int categoryId) {
        if (categoryId == DIGITAL_ITEM_CATEGORY_ID) {
            return new DigitalCart();
        } else {
            return new DefaultCart();
        }
    }
}
