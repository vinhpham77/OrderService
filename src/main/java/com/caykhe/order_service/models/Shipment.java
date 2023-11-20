package com.caykhe.order_service.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "shipment")
public class Shipment {
    @Id
    private String id;

    @NotBlank(message = "orderId không được để trống")
    private String orderId;

    @NotBlank(message = "shippingMethod không được để trống")
    private String shippingMethod;

    @NotBlank(message = "trackingNumber không được để trống")
    private String trackingNumber;

    @NotNull(message = "estimateDeliveryDate không được để trống")
    private Date estimateDeliveryDate;
}
