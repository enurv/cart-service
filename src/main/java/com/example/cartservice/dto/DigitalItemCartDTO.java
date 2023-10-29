package com.example.cartservice.dto;

import java.util.List;

public class DigitalItemCartDTO extends CartDTO {
    public List<DigitalItemDTO> items;

    public DigitalItemCartDTO(List<DigitalItemDTO> items, double totalPrice, int appliedPromotionId, double totalDiscount) {
        super(totalPrice, appliedPromotionId, totalDiscount);
        this.items = items;
    }
}
