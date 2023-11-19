package com.caykhe.order_service.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "payment")
public class Payment {
    private String id;
    private String orderId;
    private Date paymentDate;
    private String paymentMethod;
    private double amount;
}
