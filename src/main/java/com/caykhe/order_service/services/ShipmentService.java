package com.caykhe.order_service.services;

import com.caykhe.order_service.dtos.ApiException;
import com.caykhe.order_service.dtos.RequestShipment;
import com.caykhe.order_service.models.Shipment;
import com.caykhe.order_service.repositories.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipmentService {
    private final ShipmentRepository shipmentRepository;

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Shipment getShipmentById(String shipmentId) {
        return shipmentRepository.findById(shipmentId).orElse(null);
    }

    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public Shipment updateShipment(String shipmentId, RequestShipment updatedShipment) throws Exception {
        Optional<Shipment> shipmentOptional = shipmentRepository.findById(shipmentId);

        if (shipmentOptional.isPresent()) {
            Shipment shipment = shipmentOptional.get();
            shipment.setOrderId(updatedShipment.getOrderId());
            shipment.setShippingMethod(updatedShipment.getShippingMethod());
            shipment.setTrackingNumber(updatedShipment.getTrackingNumber());
            shipment.setEstimateDeliveryDate(updatedShipment.getEstimateDeliveryDate());
            return shipmentRepository.save(shipment);
        } else {
            throw new ApiException("Shipment not found", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteShipment(String shipmentId) {
        shipmentRepository.deleteById(shipmentId);
    }
}
