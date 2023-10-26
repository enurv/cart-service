package com.example.cartservice.factory;

import com.example.cartservice.dto.ItemDTO;
import com.example.cartservice.entity.item.DefaultItem;
import com.example.cartservice.entity.item.DigitalItem;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.entity.item.VasItem;

public class ItemFactory {
    public Item createItem(ItemDTO itemDto) {
        if (itemDto.categoryId == 7889) {
            return new DigitalItem(itemDto.itemId, itemDto.price, itemDto.categoryId, itemDto.sellerId, itemDto.quantity);
        } else {
            return new DefaultItem(itemDto.itemId, itemDto.price, itemDto.categoryId, itemDto.sellerId, itemDto.quantity);
        }
    }
}
