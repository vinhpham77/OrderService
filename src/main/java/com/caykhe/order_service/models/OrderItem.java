package com.caykhe.order_service.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "orderItem")
public class OrderItem {
    private String id;
    private String orderId;
    private String productId;
    private int quantity;
    private double price;
}
