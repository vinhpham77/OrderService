package com.caykhe.order_service.models;


import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Tài khoản không được để trống")
    private String userId;
    @NotBlank(message = "Tài khoản không được để trống")
    private Date orderDate;
    @NotBlank(message = "Tài khoản không được để trống")
    private Double totalAmount;
}
