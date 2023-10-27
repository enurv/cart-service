package com.example.cartservice.service;

import com.example.cartservice.dto.ItemDTO;
import com.example.cartservice.entity.cart.Cart;
import com.example.cartservice.entity.cart.DefaultCart;
import com.example.cartservice.entity.cart.DigitalCart;
import com.example.cartservice.entity.item.DefaultItem;
import com.example.cartservice.entity.item.DigitalItem;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.factory.CartFactory;
import com.example.cartservice.factory.ItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    private final ItemFactory itemFactory;
    private final CartFactory cartFactory;
    private Cart cart = null;

    @Autowired
    public ApplicationService(ItemFactory itemFactory, CartFactory cartFactory) {
        this.itemFactory = itemFactory;
        this.cartFactory = cartFactory;
    }

    public void addItem(ItemDTO itemDto) {
        Item newItem = itemFactory.createItem(itemDto);
        if (cart == null) {
            initCart(newItem.getCategoryId());
        }
        cart.addItem(newItem);
    }

    public void initCart(int categoryId) {
        cart = cartFactory.createCart(categoryId);
    }

    public void removeItem(Item item) {
        cart.removeItem(item);
        if (cart.getCartItems().isEmpty()) {
            resetCart();
        }
    }

    public void resetCart() {
        cart = null;
    }

}
