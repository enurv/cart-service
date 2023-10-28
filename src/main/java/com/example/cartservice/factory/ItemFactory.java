package com.example.cartservice.factory;

import com.example.cartservice.Constants;
import com.example.cartservice.dto.ItemDTO;
import com.example.cartservice.dto.VasItemDTO;
import com.example.cartservice.entity.item.DefaultItem;
import com.example.cartservice.entity.item.DigitalItem;
import com.example.cartservice.entity.item.Item;
import com.example.cartservice.entity.item.VasItem;
import org.springframework.stereotype.Component;


@Component
public class ItemFactory {
    public Item createItem(ItemDTO itemDto) {
        if (itemDto.categoryId == Constants.DIGITAL_ITEM_CATEGORY_ID) {
            return new DigitalItem(itemDto.itemId, itemDto.price, itemDto.categoryId, itemDto.sellerId, itemDto.quantity);
        } else {
            return new DefaultItem(itemDto.itemId, itemDto.price, itemDto.categoryId, itemDto.sellerId, itemDto.quantity);
        }
    }

    public VasItem createVasItem(VasItemDTO vasItemDto) {
        if (vasItemDto.categoryId == Constants.VAS_ITEM_CATEGORY_ID && vasItemDto.sellerId == Constants.VAS_ITEM_SELLER_ID) {
            return new VasItem(vasItemDto.itemId, vasItemDto.vasItemId, vasItemDto.price, vasItemDto.categoryId, vasItemDto.sellerId, vasItemDto.quantity);
        } else {
            //throw new Exception("Invalid VAS item");
            return null;
        }
    }
}
