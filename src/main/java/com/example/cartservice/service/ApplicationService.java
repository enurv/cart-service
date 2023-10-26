package com.example.cartservice.service;

import com.example.cartservice.dto.ItemDTO;
import com.example.cartservice.entity.Cart;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.factory.ItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    private final ItemFactory itemFactory = new ItemFactory();
    private final Cart cart;

    @Autowired
    public ApplicationService(Cart cart) {
        this.cart = cart;
    }

    public void addItem(ItemDTO itemDto) {
        Item newItem = itemFactory.createItem(itemDto);
        cart.addItem(newItem);
    }
}
