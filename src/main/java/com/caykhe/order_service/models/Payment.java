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
@Document(collection = "payment")
public class Payment {
    @Id
    private String id;

    @NotBlank(message = "orderId không được để trống")
    private String orderId;

    @NotNull(message = "paymentDate không được để trống")
    private Date paymentDate;

    @NotBlank(message = "paymentMethod không được để trống")
    private String paymentMethod;

    @Positive(message = "amount phải là số dương")
    private double amount;
}
