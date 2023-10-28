package com.example.cartservice.exception;

public class MaximumUniqueItemLimitExceededException extends BadRequestException {
    public MaximumUniqueItemLimitExceededException(String message) {
        super(message);
    }
}
