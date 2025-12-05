package com.tp.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
     private Integer quantiy;
    private Double amount;
    private String paymentStatus;  // SUCCESS, FAILED, PENDING

    @Column(name = "order_status")   // ✅ FIX: rename column
@Enumerated(EnumType.STRING)
private OrderStatus order;
}