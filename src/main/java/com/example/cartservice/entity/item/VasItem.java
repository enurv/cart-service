package com.example.cartservice.entity.item;

import com.example.cartservice.Constants;

public class VasItem extends Item {
    public int vasItemId;

    public VasItem(int itemId, int vasItemId, double price, int categoryId, int sellerId, int quantity) {
        super(itemId, price, categoryId, sellerId, quantity);
        this.vasItemId = vasItemId;
        this.maxQuantity = Constants.MAX_VAS_ITEM_QUANTITY;
        this.categoryId = Constants.VAS_ITEM_CATEGORY_ID;
        this.sellerId = Constants.VAS_ITEM_SELLER_ID;
    }
}
