package com.example.cartservice.entity.cart;

import com.example.cartservice.entity.item.DigitalItem;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.exception.NonCompatibleItemTypeException;
import com.example.cartservice.service.promotion.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DigitalItemCart extends Cart {

    PromotionService promotionService;

    @Autowired
    public DigitalItemCart(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @Override
    public void addItem(Item newItem) {
        if (isNewItemCompatible(newItem)) {
            Item existingItem = findItemById(newItem.getId());
            if (existingItem != null) {
                addExistingItem(existingItem, newItem);
            } else {
                addNewItem(newItem);
            }
        } else {
            throw new NonCompatibleItemTypeException("You are trying to add a default item to a digital item cart.");
        }
        calculateTotalPrice();
        calculateDiscount();
    }


    @Override
    protected void calculateDiscount() {
        promotion = promotionService.selectBestPromotion(this);
        totalDiscount = promotion.calculateDiscount(this);
    }

    @Override
    protected void calculateTotalPrice() {
        totalPrice = items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }


    public boolean isNewItemCompatible(Item item) {
        return item instanceof DigitalItem;
    }
}
