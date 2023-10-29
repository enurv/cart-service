package com.example.cartservice.dto;

import com.example.cartservice.entity.item.DefaultItem;
import com.example.cartservice.entity.item.VasItem;

import java.util.List;

public class DefaultItemDTO extends ItemDTO {
    public List<VasItemDTO> vasItems;

    public DefaultItemDTO(int itemId, int categoryId, int sellerId, double price, int quantity, List<VasItemDTO> vasItems) {
        super(itemId, categoryId, sellerId, price, quantity);
        this.vasItems = vasItems;
    }

    public DefaultItemDTO(DefaultItem defaultItem) {
        super(defaultItem.getId(), defaultItem.getCategoryId(), defaultItem.getSellerId(), defaultItem.getPrice(), defaultItem.getQuantity());
        this.vasItems = defaultItem.getVasItems().stream().map(VasItemDTO::new).toList();
    }
}
