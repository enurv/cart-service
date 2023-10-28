package com.example.cartservice.exception;

public class MaximumItemLimitExceededException extends BadRequestException {
    public MaximumItemLimitExceededException(String message) {
        super(message);
    }
}
