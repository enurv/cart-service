package com.example.cartservice.dto;

import java.util.List;

public class DefaultItemCartDTO extends CartDTO {
    public boolean result;
    public List<DefaultItemDTO> message;

    public DefaultItemCartDTO(boolean result, List<DefaultItemDTO> message) {
        this.result = result;
        this.message = message;
    }
}
