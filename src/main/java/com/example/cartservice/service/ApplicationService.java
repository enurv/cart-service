package com.example.cartservice.service;

import com.example.cartservice.dto.ItemDTO;
import com.example.cartservice.entity.cart.Cart;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.factory.CartFactory;
import com.example.cartservice.factory.ItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
        if (cart == null) {
            initCart(itemDto.categoryId);
        }
        Item newItem = itemFactory.createItem(itemDto);
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
