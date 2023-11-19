package com.caykhe.order_service.repositories;

import com.caykhe.order_service.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends MongoRepository<Order,String> {
}
