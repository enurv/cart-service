package com.example.cartservice.dto;

public class ResponseDTO {
    public boolean result;
    public String message;

    public ResponseDTO(boolean result, String message) {
        this.result = result;
        this.message = message;
    }
}
