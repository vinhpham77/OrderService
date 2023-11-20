package com.caykhe.order_service.repositories;

import com.caykhe.order_service.models.Payment;
import com.caykhe.order_service.models.Shipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends MongoRepository<Shipment,String> {
}
