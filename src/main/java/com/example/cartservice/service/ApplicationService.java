package com.example.cartservice.service;

import com.example.cartservice.dto.*;
import com.example.cartservice.entity.cart.Cart;
import com.example.cartservice.entity.cart.DigitalItemCart;
import com.example.cartservice.entity.item.DefaultItem;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.entity.item.VasItem;
import com.example.cartservice.factory.CartFactory;
import com.example.cartservice.factory.ItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void addVasItem(VasItemDTO vasItemDto) {
        VasItem newVasItem = itemFactory.createVasItem(vasItemDto);
        cart.addItem(newVasItem);
    }

    private void initCart(int categoryId) {
        cart = cartFactory.createCart(categoryId);
    }

    public void removeItem(ItemDTO item) {
        cart.removeItem(item.itemId);
        if (cart.getItems().isEmpty()) {
            resetCart();
        }
    }

    public void resetCart() {
        cart.resetCart();
        cart = null;
    }

    public CartDTO displayCart() {
        if (cart == null) {
            return new CartDTO(false, null);
        }
        if (cart instanceof DigitalItemCart) {
            List<DigitalItemDTO> digitalItemDTOs = cart.getItems()
                    .stream()
                    .map(item -> new DigitalItemDTO(item.getId(), item.getCategoryId(), item.getSellerId(), item.getPrice(), item.getQuantity()))
                    .toList();
            return new DigitalItemCartDTO(true, digitalItemDTOs);
        } else {
            List<DefaultItemDTO> defaultItemDTOs = cart.getItems()
                    .stream()
                    .map(item -> new DefaultItemDTO((DefaultItem) item))
                    .toList();
            return new DefaultItemCartDTO(true, defaultItemDTOs);
        }
    }

}
