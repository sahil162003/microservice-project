package com.tp.service;

import com.tp.dto.OrderDto;
import com.tp.entity.Orders;


public interface OrderService {
     Orders createorder(OrderDto orderDto);
}
