package com.example.cartservice.entity.cart;

import com.example.cartservice.Constants;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.entity.promotion.Promotion;
import com.example.cartservice.exception.MaximumItemLimitExceededException;
import com.example.cartservice.exception.MaximumUniqueItemLimitExceededException;
import com.example.cartservice.service.promotion.PromotionServiceProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.cartservice.Constants.MAX_ITEM_NUMBER;

public abstract class Cart {
    private UUID id;
    protected double totalPrice;
    protected Promotion promotion;
    protected double totalDiscount;
    protected List<Item> items = new ArrayList<Item>();

    protected Item findItemById(int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findAny()
                .orElse(null);
    }

    public abstract void addItem(Item newItem);

    protected void addExistingItem(Item existingItem, Item newItem) {
        if (items.stream().reduce(0, (subtotal, element) -> subtotal + element.getQuantity(), Integer::sum) + newItem.getQuantity() > Constants.MAX_ITEM_NUMBER) {
            throw new MaximumItemLimitExceededException("You cannot add more than " + MAX_ITEM_NUMBER + "of the item.");
        } else {
            existingItem.setQuantity(newItem.getQuantity() + existingItem.getQuantity());
        }
    }

    protected void addNewItem(Item newItem) {
        if (items.size() >= Constants.MAX_UNIQUE_ITEM_NUMBER) {
            throw new MaximumUniqueItemLimitExceededException("You cannot add more than " + Constants.MAX_UNIQUE_ITEM_NUMBER + " unique items.");
        } else {
            items.add(newItem);
        }
    }

    public abstract void removeItem(Item item);

    public List<Item> getCartItems() {
        return null;
    }

    public void resetCart() {
        items.clear();
        promotion = null;
        totalDiscount = 0;
        totalPrice = 0;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    protected void selectPromotion() {
        promotion = PromotionServiceProvider.getPromotionService().selectBestPromotion(items);
        totalDiscount = promotion.calculateDiscount(items);
    }

    protected abstract void calculateTotalPrice();

}
