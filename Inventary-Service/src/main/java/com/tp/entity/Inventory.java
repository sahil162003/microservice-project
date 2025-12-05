package com.tp.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inventory")
@Data
public class Inventory {
    @Id
    private Long productId;
    private Integer stock;

}
