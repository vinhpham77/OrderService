package com.caykhe.order_service.repositories;

import com.caykhe.order_service.models.OrderItem;
import com.caykhe.order_service.models.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment,String>  {
}
