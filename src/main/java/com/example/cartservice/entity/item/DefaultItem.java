package com.example.cartservice.entity.item;

import com.example.cartservice.Constants;

import java.util.List;

public class DefaultItem extends Item {
    private final int MAX_VAS_ITEM_NUMBER = 3;
    private List<VasItem> vasItems;

    public DefaultItem(int itemId, double price, int categoryId, int sellerId, int quantity) {
        super(itemId, price, categoryId, sellerId, quantity);
        this.maxQuantity = Constants.MAX_DEFAULT_ITEM_QUANTITY;
    }

    public void addVasItems(List<VasItem> vasItems) {
    }

    public void removeVasItems(List<VasItem> vasItems) {
    }

    public void resetVasItems() {
    }
}
