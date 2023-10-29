package com.example.cartservice.dto;

import java.util.List;

public class CartDTO {
    public List<ItemDTO> items;
    public double totalPrice;
    public int appliedPromotionId;
    public double totalDiscount;
}
