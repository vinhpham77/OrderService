package com.caykhe.order_service.dtos;

import lombok.Data;

import java.util.Date;
@Data
public class RequestOrderHistory {
    private String orderId;
    private String status;
    private Date updateAt;
}
