package com.caykhe.order_service.repositories;

import com.caykhe.order_service.models.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderItemRepository extends MongoRepository<OrderItem,String> {

}
