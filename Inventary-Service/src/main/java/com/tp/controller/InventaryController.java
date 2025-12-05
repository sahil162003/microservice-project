package com.tp.controller;

import com.tp.dto.InventaryDto;
import com.tp.dto.InventoryResponse;
import com.tp.entity.Inventory;
import com.tp.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/inventary")

public class InventaryController {
 private  final InventoryService inventoryService;

    @PostMapping("/reserve")
    public ResponseEntity<InventoryResponse> reserveStock(@RequestBody InventaryDto inventory){

        inventoryService.reserveStock(inventory);

        InventoryResponse inventoryResponse=new InventoryResponse();
        inventoryResponse.setProductId(inventory.getProductId());
        inventoryResponse.setQuantityReserved(inventory.getQuantity());
        inventoryResponse.setMessage("stock reserved succesfully");

        return ResponseEntity.ok(inventoryResponse);
    }



    @PostMapping("/add-stock")
    public ResponseEntity<String> addStock(@RequestBody Inventory inventory) {
        inventoryService.addStock(inventory);
        return ResponseEntity.ok("Stock added");
    }
    @PostMapping("/cancel-reservation")
    public ResponseEntity<String> cancelReservation(@RequestBody InventaryDto request) {
        inventoryService.cancelReservation(request);
        return ResponseEntity.ok("Reservation cancelled");
    }
}
