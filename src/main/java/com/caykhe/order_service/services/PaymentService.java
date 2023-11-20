package com.caykhe.order_service.services;

import com.caykhe.order_service.dtos.RequestPayment;
import com.caykhe.order_service.models.Payment;
import com.caykhe.order_service.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(String paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(String paymentId, RequestPayment updatedPayment) throws Exception {
        Optional<Payment> paymentOptional = paymentRepository.findById(paymentId);

        if (paymentOptional.isPresent()) {
            Payment payment = paymentOptional.get();
            payment.setOrderId(updatedPayment.getOrderId());
            payment.setPaymentDate(updatedPayment.getPaymentDate());
            payment.setPaymentMethod(updatedPayment.getPaymentMethod());
            payment.setAmount(updatedPayment.getAmount());
            return paymentRepository.save(payment);
        } else {
            throw new Exception("Payment not found");
        }
    }

    public void deletePayment(String paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}
