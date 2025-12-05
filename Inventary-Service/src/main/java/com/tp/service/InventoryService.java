package com.tp.service;

import com.tp.dto.InventaryDto;
import com.tp.entity.Inventory;

public interface InventoryService {
    void reserveStock(InventaryDto inventory);


    void addStock(Inventory inventory);

    void cancelReservation(InventaryDto request);
}
