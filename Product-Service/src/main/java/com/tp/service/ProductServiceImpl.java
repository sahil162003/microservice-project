package com.tp.service;

import com.tp.dto.ProductDto;
import com.tp.entity.Product;
import com.tp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<ProductDto> fetchAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class)).toList();
    }

    @Override
    public ProductDto fetchOne(Long id) {
        return productRepository.findById(id)
                .map(product -> modelMapper.map(product, ProductDto.class))
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
