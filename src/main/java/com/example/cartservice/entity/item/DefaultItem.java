package com.example.cartservice.entity.item;

import java.util.List;

public class DefaultItem extends Item {
    private final int MAX_VAS_ITEM_AMOUNT = 3;
    private List<VasItem> vasItems;

    public void addVasItems(List<VasItem> vasItems) {}

    public void removeVasItems(List<VasItem> vasItems) {}

    public void resetVasItems() {}
}
