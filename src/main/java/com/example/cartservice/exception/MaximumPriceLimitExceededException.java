package com.example.cartservice.exception;

public class MaximumPriceLimitExceededException extends BadRequestException {
    public MaximumPriceLimitExceededException(String message) {
        super(message);
    }
}
