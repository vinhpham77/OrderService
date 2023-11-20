package com.caykhe.order_service.dtos;

import lombok.Data;

@Data
public class RequestOrderItem {
    private String orderId;
    private String productId;
    private int quantity;
    private double price;
}
