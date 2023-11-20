package com.caykhe.order_service.dtos;

import lombok.Data;

import java.util.Date;
@Data
public class RequestPayment {
    private String orderId;
    private Date paymentDate;
    private String paymentMethod;
    private double amount;
}
