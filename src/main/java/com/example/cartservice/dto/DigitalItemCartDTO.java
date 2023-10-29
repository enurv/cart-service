package com.example.cartservice.dto;

import java.util.List;

public class DigitalItemCartDTO extends CartDTO {
    public boolean result;
    public List<DigitalItemDTO> message;

    public DigitalItemCartDTO(boolean result, List<DigitalItemDTO> message) {
        this.result = result;
        this.message = message;
    }
}
