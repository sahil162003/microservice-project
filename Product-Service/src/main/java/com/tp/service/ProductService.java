package com.tp.service;


import com.tp.dto.ProductDto;
import com.tp.entity.Product;

import java.util.List;


public interface ProductService   {

    void addProduct(Product product);

    List<ProductDto> fetchAll();

    ProductDto fetchOne(Long id);
}
