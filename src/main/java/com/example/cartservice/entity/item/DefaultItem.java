package com.example.cartservice.entity.item;

import com.example.cartservice.Constants;
import com.example.cartservice.exception.MaximumItemLimitExceededException;
import com.example.cartservice.exception.MaximumUniqueItemLimitExceededException;

import java.util.List;

public class DefaultItem extends Item {
    private List<VasItem> vasItems;

    public DefaultItem(int itemId, double price, int categoryId, int sellerId, int quantity) {
        super(itemId, price, categoryId, sellerId);
        setQuantity(quantity);
    }

    public List<VasItem> getVasItems() {
        return vasItems;
    }

    public void addVasItem(VasItem newVasItem) {
        VasItem existingVasItem = findVasItemById(newVasItem.getVasItemId());
        if (existingVasItem != null) {
            addExistingVasItem(existingVasItem, newVasItem);
        } else {
            addNewVasItem(newVasItem);
        }
    }

    private void addNewVasItem(VasItem newVasItem) {
        if (vasItems.size() >= Constants.MAX_UNIQUE_VAS_ITEM_NUMBER) {
            throw new MaximumUniqueItemLimitExceededException("You cannot add more than " + Constants.MAX_UNIQUE_VAS_ITEM_NUMBER + " unique vas items.");
        } else {
            vasItems.add(newVasItem);
        }
    }

    private void addExistingVasItem(VasItem existingVasItem, VasItem newVasItem) {
        if (vasItems.stream().reduce(0, (subtotal, element) -> subtotal + element.getQuantity(), Integer::sum) + newVasItem.getQuantity() > Constants.MAX_ITEM_QUANTITY) {
            throw new MaximumItemLimitExceededException("You cannot add more than " + Constants.MAX_ITEM_QUANTITY + " items.");
        } else {
            existingVasItem.setQuantity(newVasItem.getQuantity() + existingVasItem.getQuantity());
        }
    }

    public void removeVasItem(VasItem vasItem) {
    }

    private VasItem findVasItemById(int id) {
        return vasItems.stream()
                .filter(vasItem -> vasItem.getVasItemId() == id)
                .findAny()
                .orElse(null);
    }


}
