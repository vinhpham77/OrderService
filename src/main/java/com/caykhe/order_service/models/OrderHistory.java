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
@Document(collection = "orderHistory")
public class OrderHistory {
    @Id
    private String id;
    @NotBlank(message = "id order không được để trống")
    private String orderId;
    @NotBlank(message = "status không được để trống")
    private String status;
    @NotNull(message = "Date không được để trống")
    private Date updateAt;
}
