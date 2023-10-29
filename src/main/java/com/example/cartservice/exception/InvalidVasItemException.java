package com.example.cartservice.exception;

public class InvalidVasItemException extends BadRequestException {
    public InvalidVasItemException(String message) {
        super(message);
    }
}
