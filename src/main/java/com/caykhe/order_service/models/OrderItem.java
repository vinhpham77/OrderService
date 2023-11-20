package com.caykhe.order_service.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "orderItem")
public class OrderItem {
    @Id
    private String id;

    @NotBlank(message = "id order không được để trống")
    private String orderId;

    @NotBlank(message = "id product không được để trống")
    private String productId;

    @NotNull(message = "quantity không được để trống")
    private int quantity;

    @NotNull(message = "price không được để trống")
    private double price;
}
