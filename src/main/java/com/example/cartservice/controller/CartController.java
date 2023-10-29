package com.example.cartservice.controller;

import com.example.cartservice.dto.ItemDTO;
import com.example.cartservice.dto.ResponseDTO;
import com.example.cartservice.dto.VasItemDTO;
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

    @PostMapping("/item/add")
    public ResponseEntity<ResponseDTO> addItem(@RequestBody ItemDTO newItem) {
        applicationService.addItem(newItem);
        return ResponseEntity.ok(new ResponseDTO(true, "Item added to cart"));
    }

    @PostMapping("/item/add/vas")
    public ResponseEntity<ResponseDTO> addVasItem(@RequestBody VasItemDTO newVasItem) {
        applicationService.addVasItem(newVasItem);
        return ResponseEntity.ok(new ResponseDTO(true, "VasItem added to cart"));
    }

    @DeleteMapping("/cart/reset")
    public ResponseEntity<ResponseDTO> resetCart() {
        applicationService.resetCart();
        return ResponseEntity.ok(new ResponseDTO(true, "Cart reset successfully"));
    }


}
