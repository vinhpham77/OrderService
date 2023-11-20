package com.caykhe.order_service.services;

import com.caykhe.order_service.dtos.ApiException;
import com.caykhe.order_service.dtos.RequestPayment;
import com.caykhe.order_service.models.Payment;
import com.caykhe.order_service.repositories.PaymentRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderService orderService;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(String paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    public Payment createPayment(RequestPayment requestPayment) {
        if(orderService.CheckOrder(requestPayment.getOrderId())){
            Payment payment= Payment.builder()
                    .orderId(requestPayment.getOrderId())
                    .paymentDate(requestPayment.getPaymentDate())
                    .paymentMethod(requestPayment.getPaymentMethod())
                    .amount(requestPayment.getAmount())
                    .build();
            return paymentRepository.save(payment);
        }
        else
            throw new ApiException("Không tìm thấy Order id", HttpStatus.NOT_FOUND);

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
            throw new ApiException("Payment not found",HttpStatus.NOT_FOUND);
        }
    }
    public Boolean checkPayment(String id) {
        return this.getPaymentById(id) != null;

    }
    public void deletePayment(String paymentId) {
        if (this.checkPayment(paymentId))
        paymentRepository.deleteById(paymentId);
        else
            throw new ApiException("Không tìm thấy payment ",HttpStatus.NOT_FOUND);
    }
}
