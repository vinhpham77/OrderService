package com.caykhe.order_service.dtos;

import lombok.Data;

import java.util.Date;
@Data

public class RequestOrder {
    private String userId;
    private Date orderDate;
    private Double totalAmount;
}
