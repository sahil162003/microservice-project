package com.tp.service;

import com.tp.dto.InventaryDto;
import com.tp.entity.Inventory;
import com.tp.repository.InventoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{
    private  final InventoryRepository inventoryRepository;


    @Override
    @Transactional
    public void reserveStock(InventaryDto inventory) {
        Inventory inventory1 =inventoryRepository.findById(inventory.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found in inventory"));

        if (inventory1.getStock() < inventory.getQuantity())
            throw new RuntimeException("Not enough stock available");


        inventory1.setStock(inventory1.getStock() - inventory.getQuantity());
        inventoryRepository.save(inventory1); // reservation
    }



    @Override
    @Transactional
    public void addStock(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    @Override
    @Transactional
    public void cancelReservation(InventaryDto request) {
        Inventory inventory1 =inventoryRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found in inventory"));
        inventory1.setStock(inventory1.getStock() + request.getQuantity());
        inventoryRepository.save(inventory1); // rollback
    }

}
