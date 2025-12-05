package com.tp.client;

import com.tp.dto.PaymentRequest;
import com.tp.dto.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentClient {
    @PostMapping("/payment/process")
    PaymentResponse process(@RequestBody PaymentRequest request);
}
