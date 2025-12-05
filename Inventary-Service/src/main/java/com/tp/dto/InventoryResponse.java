package com.tp.dto;

import lombok.Data;

@Data
public class InventoryResponse {
    private Long productId;
    private Integer quantityReserved;
    private String message;
}
