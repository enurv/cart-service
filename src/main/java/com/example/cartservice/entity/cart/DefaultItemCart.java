package com.example.cartservice.entity.cart;

import com.example.cartservice.entity.item.DefaultItem;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.entity.item.VasItem;
import com.example.cartservice.exception.NonCompatibleItemTypeException;
import com.example.cartservice.service.promotion.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultItemCart extends Cart {
    PromotionService promotionService;

    @Autowired
    public DefaultItemCart(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @Override
    public void addItem(Item newItem) {
        if (newItem instanceof DefaultItem) {
            addDefaultItem((DefaultItem) newItem);
        } else if (newItem instanceof VasItem) {
            addVasItem((VasItem) newItem);
        } else {
            throw new NonCompatibleItemTypeException("You are trying to add a digital item to a default item cart");
        }
        selectPromotion();
    }

    private void addDefaultItem(DefaultItem newDefaultItem) {
        Item existingItem = findItemById(newDefaultItem.getId());
        if (existingItem != null) {
            addExistingItem(existingItem, newDefaultItem);
        } else {
            addNewItem(newDefaultItem);
        }
    }

    private void addVasItem(VasItem newVasItem) {
        DefaultItem defaultItem = (DefaultItem) findItemById(newVasItem.getId());
        defaultItem.addVasItem(newVasItem);
    }


    @Override
    public void removeItem(Item item) {

    }

    @Override
    protected void selectPromotion() {
        promotionService.selectBestPromotion(this);
    }

    @Override
    protected void calculateTotalPrice() {
        totalPrice = items.stream()
                .map(item -> (DefaultItem) item)
                .mapToDouble(defaultItem -> {
                    double defaultItemPrice = defaultItem.getPrice() * defaultItem.getQuantity();
                    double vasItemsPrice = defaultItem.getVasItems().stream()
                            .mapToDouble(vasItem -> vasItem.getPrice() * vasItem.getQuantity())
                            .sum();
                    return defaultItemPrice + vasItemsPrice;
                })
                .sum();
    }


}
