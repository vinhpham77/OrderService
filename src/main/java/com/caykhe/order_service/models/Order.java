package com.caykhe.order_service.models;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "order")
public class Order {
    private String id;
    private String userId;
    private Date orderDate;
    private Double totalAmount;

}
