package com.example.cartservice.controller;

import com.example.cartservice.dto.ItemDTO;
import com.example.cartservice.service.ApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CartController {

    private final ApplicationService applicationService;

    public CartController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/helloWorld")
    public String helloWorld() {
        ItemDTO newItem = new ItemDTO(1, 5000, 8, 29.99, 2);
        applicationService.addItem(newItem);
        return "hello world";
    }
}
