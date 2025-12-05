package com.tp.controller;


import com.tp.dto.ProductDto;
import com.tp.entity.Product;
import com.tp.service.ProductService;
import com.tp.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private  final ProductService productService;

    @PostMapping("/addproduct")
    public  String addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return "product sucessfully added";
    }

    @GetMapping("/fetchall")
    public ResponseEntity<List<ProductDto>> fetchAll(){
        List<ProductDto> products=productService.fetchAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(products);
    }

    @GetMapping("/fetchOne/{id}")
    public  ResponseEntity<ProductDto> fetchOne(@PathVariable Long id){
        ProductDto productDtos=productService.fetchOne(id);
        return ResponseEntity.ok(productDtos);
    }


}
