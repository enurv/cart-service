package com.example.cartservice.entity.cart;

import com.example.cartservice.Constants;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.entity.promotion.Promotion;
import com.example.cartservice.exception.MaximumItemLimitExceededException;
import com.example.cartservice.exception.MaximumPriceLimitExceededException;
import com.example.cartservice.exception.MaximumUniqueItemLimitExceededException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


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
            throw new MaximumItemLimitExceededException("You cannot add more than " + Constants.MAX_ITEM_NUMBER + " of the same item.");
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
        calculatePrices();
        if (isPriceLimitExceeded()) {
            removeItem(newItem.getId());
            calculatePrices();
            throw new MaximumPriceLimitExceededException("You cannot add more than " + Constants.MAX_PRICE + " price.");
        }
    }

    public void removeItem(int itemId) {
        items.removeIf(existingItem -> existingItem.getId() == itemId);
        calculatePrices();
    }

    protected abstract void calculateDiscount();

    protected abstract void calculateTotalPrice();

    protected boolean isPriceLimitExceeded() {
        return totalPrice - totalDiscount > Constants.MAX_PRICE;
    }

    public void resetCart() {
        items.clear();
        promotion = null;
        totalDiscount = 0;
        totalPrice = 0;
    }

    protected void calculatePrices() {
        calculateTotalPrice();
        calculateDiscount();
    }

    public int getPromotionId() {
        return promotion.getPromotionId();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public List<Item> getItems() {
        return items;
    }

}
