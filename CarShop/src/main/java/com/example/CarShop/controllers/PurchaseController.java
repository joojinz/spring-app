package com.example.CarShop.controllers;

import com.dto.PurchaseRequestDTO;
import com.example.CarShop.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

  @Autowired private PurchaseService purchaseService;

  @PostMapping
  public ResponseEntity<Void> purchase(@RequestBody PurchaseRequestDTO data) {
    purchaseService.checkout(data.userID(), data.carID());
    return ResponseEntity.ok().build();
  }
}
