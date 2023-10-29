package com.example.cartservice.factory;

import com.example.cartservice.Constants;
import com.example.cartservice.entity.cart.Cart;
import com.example.cartservice.entity.cart.DefaultItemCart;
import com.example.cartservice.entity.cart.DigitalItemCart;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CartFactory {
    private final BeanFactory beanFactory;

    @Autowired
    public CartFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }


    public Cart createCart(int categoryId) {
        if (categoryId == Constants.DIGITAL_ITEM_CATEGORY_ID) {
            return beanFactory.getBean(DigitalItemCart.class);
        } else {
            return beanFactory.getBean(DefaultItemCart.class);
        }
    }
}
