package com.example.cartservice.factory;

import com.example.cartservice.dto.ItemDTO;
import com.example.cartservice.entity.item.DefaultItem;
import com.example.cartservice.entity.item.DigitalItem;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.entity.item.VasItem;
import org.springframework.stereotype.Component;

import static com.example.cartservice.Constants.DIGITAL_ITEM_CATEGORY_ID;

@Component
public class ItemFactory {
    public Item createItem(ItemDTO itemDto) {
        if (itemDto.categoryId == DIGITAL_ITEM_CATEGORY_ID) {
            return new DigitalItem(itemDto.itemId, itemDto.price, itemDto.categoryId, itemDto.sellerId, itemDto.quantity);
        } else {
            return new DefaultItem(itemDto.itemId, itemDto.price, itemDto.categoryId, itemDto.sellerId, itemDto.quantity);
        }
    }
}
