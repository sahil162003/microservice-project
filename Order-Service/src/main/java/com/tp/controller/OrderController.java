package com.tp.controller;

import com.tp.dto.OrderDto;
import com.tp.entity.Orders;
import com.tp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordercontroller")
@RequiredArgsConstructor
public class OrderController {
     private  final OrderService orderService;
    @PostMapping("/orders")
    public ResponseEntity<Orders> createorder(@RequestBody OrderDto orderDto){

        return ResponseEntity.ok(orderService.createorder(orderDto));
    }


}
