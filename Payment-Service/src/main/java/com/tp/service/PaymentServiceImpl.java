package com.tp.service;

import com.tp.dto.PaymentRequest;
import com.tp.dto.PaymentResponse;
import com.tp.entity.Payment;
import com.tp.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

private final PaymentRepository paymentRepository;

    @Override
    public PaymentResponse processPayment(PaymentRequest request) {

        Payment payment=new Payment();
        payment.setPaymentTime(LocalDateTime.now());
        payment.setOrderId(request.getOrderId());
        payment.setAmount(request.getAmount());

        String txnId = UUID.randomUUID().toString();   // 🔥 generate transactionId

        payment.setTransactionId(txnId);
            boolean success = Math.random() < 0.50; // 80% success

            if (success) {
                payment.setStatus("Success");



            } else {
                payment.setStatus("Failed");

            }
        paymentRepository.save(payment);

        return new PaymentResponse(
                payment.getStatus(),
                payment.getTransactionId()
        );
        }
    }

