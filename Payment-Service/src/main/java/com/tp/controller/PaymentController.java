package com.tp.controller;


import com.tp.dto.PaymentRequest;
import com.tp.dto.PaymentResponse;
import com.tp.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    private  final PaymentService paymentService;
    @PostMapping("/process")
    public PaymentResponse process(@RequestBody PaymentRequest request) {
        return paymentService.processPayment(request);
    }
}
