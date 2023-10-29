package com.example.cartservice.controller;

import com.example.cartservice.dto.*;
import com.example.cartservice.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CartController {

    private final ApplicationService applicationService;

    public CartController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/items/add")
    public ResponseEntity<ResponseDTO> addItem(@RequestBody ItemDTO newItem) {
        applicationService.addItem(newItem);
        return ResponseEntity.ok(new ResponseDTO(true, "Item added to cart"));
    }

    @PostMapping("/items/add/vas")
    public ResponseEntity<ResponseDTO> addVasItem(@RequestBody VasItemDTO newVasItem) {
        applicationService.addVasItem(newVasItem);
        return ResponseEntity.ok(new ResponseDTO(true, "VasItem added to cart"));
    }

    @PostMapping("/items/remove")
    public ResponseEntity<ResponseDTO> removeItem(@RequestBody ItemDTO removeItem) {
        applicationService.removeItem(removeItem);
        return ResponseEntity.ok(new ResponseDTO(true, "Item successfully removed from cart"));
    }

    @GetMapping("/cart/display")
    public ResponseEntity<CartDisplayDTO> displayCart() {
        CartDisplayDTO cart = applicationService.displayCart();
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/cart/reset")
    public ResponseEntity<ResponseDTO> resetCart() {
        applicationService.resetCart();
        return ResponseEntity.ok(new ResponseDTO(true, "Cart reset successfully"));
    }


}
