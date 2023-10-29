package com.example.cartservice.service.promotion;

import com.example.cartservice.entity.item.Item;
import com.example.cartservice.entity.promotion.Promotion;

import java.util.List;

public interface IPromotionService {
    Promotion selectBestPromotion(List<Item> items);
}
