package com.tp.service;

import com.tp.dto.PaymentRequest;
import com.tp.dto.PaymentResponse;

public interface PaymentService {
    PaymentResponse processPayment(PaymentRequest request);
}
