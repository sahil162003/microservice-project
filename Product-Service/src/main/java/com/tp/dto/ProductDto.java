package com.tp.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private boolean availability;

}
