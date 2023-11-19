package com.caykhe.order_service.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "orderHistory")
public class OrderHistory {
    private String id;
    private String orderId;
    private String status;
    private Date updateAt;
}
