package com.example.cartservice.dto;

public class CartDisplayDTO {
    public boolean result;
    public CartDTO message;

    public CartDisplayDTO(boolean result, CartDTO message) {
        this.result = result;
        this.message = message;
    }

}
