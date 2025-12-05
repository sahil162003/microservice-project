package com.tp.client;

import com.tp.dto.InventaryDto;
import com.tp.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "INVENTORY-SERVICE")
public interface InventoryClient {
    @PostMapping("inventary/reserve")
    public InventoryResponse reserveStock(@RequestBody InventaryDto inventory);

    @PostMapping("inventary/cancel-reservation")
    public ResponseEntity<String> cancelReservation(@RequestBody InventaryDto request) ;
}
