package com.example.cartservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CartController {
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "hello world";
    }
}
