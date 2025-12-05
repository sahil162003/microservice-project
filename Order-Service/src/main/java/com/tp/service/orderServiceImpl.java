package com.tp.service;


import com.tp.client.InventoryClient;
import com.tp.client.PaymentClient;
import com.tp.dto.*;
import com.tp.entity.OrderStatus;
import com.tp.entity.Orders;
import com.tp.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class orderServiceImpl implements OrderService {
    private  final OrderRepository orderRepository;
     private final RestTemplate restTemplates;
     private final PaymentClient paymentClient;
     private  final  InventoryClient inventoryClient;
    @Override

    public Orders createorder(OrderDto orderDto) {

        System.out.println(" enter in orderservice ");

        String url = "http://PRODUCT-SERVICE/product/fetchOne/" + orderDto.getProductId();
        ProductDto product = restTemplates.getForObject(url,ProductDto .class);

        System.out.println("i get productDto");

        if (product == null || !product.isAvailability()) {
            throw new RuntimeException("Product  Not Available");
        }
        System.out.println("comes in in=nventaryDto");
        // 2️⃣ RESERVE STOCK using Feign
        InventaryDto inv = new InventaryDto();
        inv.setProductId(orderDto.getProductId());
        inv.setQuantity(orderDto.getQuantiy());


        InventoryResponse invRes = inventoryClient.reserveStock(inv);

        // 3️⃣ PAYMENT using Feign
        PaymentRequest payment = new PaymentRequest();
        payment.setAmount(product.getPrice() * orderDto.getQuantiy());

        PaymentResponse payRes = paymentClient.process(payment);

        // 4️⃣ SAVE ORDER
        Orders order = new Orders();
        order.setAmount(payment.getAmount());
        order.setProductId(orderDto.getProductId());
        order.setQuantiy(orderDto.getQuantiy());
        System.out.println(payRes.getStatus());
        if (payRes.getStatus().equalsIgnoreCase("SUCCESS")) {
            // 🟢 PAYMENT SUCCESS
            order.setPaymentStatus("CONFIRMED");
            order.setOrder(OrderStatus.SUCCESS);

        } else {
            // 🔴 PAYMENT FAILED → ROLLBACK STOCK + MARK ORDER FAILED
            order.setPaymentStatus("FAILED");
            order.setOrder(OrderStatus.FAILED);

            System.out.println("Payment failed → Restoring inventory...");

            // rollback inventory
            inventoryClient.cancelReservation(inv);
        }



        return orderRepository.save(order);
    }
}
