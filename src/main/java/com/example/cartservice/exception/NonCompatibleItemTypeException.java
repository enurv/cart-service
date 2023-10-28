package com.example.cartservice.exception;

public class NonCompatibleItemTypeException extends BadRequestException {
    public NonCompatibleItemTypeException(String message) {
        super(message);
    }
}
