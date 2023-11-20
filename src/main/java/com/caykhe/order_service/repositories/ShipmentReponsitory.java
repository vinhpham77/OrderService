package com.caykhe.order_service.repositories;

import com.caykhe.order_service.models.Shipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentReponsitory extends MongoRepository<Shipment,String> {
}
