package com.caykhe.order_service.repositories;

import com.caykhe.order_service.models.OrderHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryRepository extends MongoRepository<OrderHistory,String> {
}
