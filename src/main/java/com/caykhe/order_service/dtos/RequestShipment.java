package com.caykhe.order_service.dtos;

import lombok.Data;

import java.util.Date;
@Data
public class RequestShipment {
    private String orderId;
    private String shippingMethod;
    private String trackingNumber;
    private Date estimateDeliveryDate;
}
