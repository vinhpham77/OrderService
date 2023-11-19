package com.caykhe.order_service.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "shipment")
public class Shipment {
    private String id;
    private String orderId;
    private String shippingMethod;
    private String trackingNumber;
    private Date estimateDeliveryDate;
}
