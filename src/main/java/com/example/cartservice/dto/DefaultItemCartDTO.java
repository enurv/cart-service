package com.example.cartservice.dto;

import java.util.List;

public class DefaultItemCartDTO extends CartDTO {
    public List<DefaultItemDTO> items;

    public DefaultItemCartDTO(List<DefaultItemDTO> items, double totalPrice, int appliedPromotionId, double totalDiscount) {
        super(totalPrice, appliedPromotionId, totalDiscount);
        this.items = items;
    }
}
