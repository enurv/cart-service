package com.example.cartservice.dto;

import java.util.List;

public class CartDTO {
    public CartDTO(boolean result, List<ItemDTO> message) {
        this.result = result;
        this.message = message;
    }

    public boolean result;
    public List<ItemDTO> message;

    public CartDTO() {

    }
}
