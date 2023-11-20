package com.caykhe.order_service.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "order")
public class Order {
    @Id
    private String id;

    @NotBlank(message = "userId không được để trống")
    private String userId;

    @NotNull(message = "orderDate không được để trống")
    private Date orderDate;

    @Positive(message = "totalAmount phải là số dương")
    private Double totalAmount;
}
