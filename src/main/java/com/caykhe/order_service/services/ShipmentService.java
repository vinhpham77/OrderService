package com.caykhe.order_service.services;

import com.caykhe.order_service.dtos.ApiException;
import com.caykhe.order_service.dtos.RequestShipment;
import com.caykhe.order_service.models.Order;
import com.caykhe.order_service.models.Shipment;
import com.caykhe.order_service.repositories.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipmentService {
    private final ShipmentRepository shipmentRepository;
    private final OrderService orderService;

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Shipment getShipmentById(String shipmentId) {
        return shipmentRepository.findById(shipmentId).orElse(null);
    }

    public Shipment createShipment(RequestShipment requestShipment) {
        Order order = orderService.getOrderById(requestShipment.getOrderId())
                .orElseThrow(() -> new UsernameNotFoundException("Order not found"));
        Shipment shipment = Shipment.builder()
                .orderId(requestShipment.getOrderId())
                .estimateDeliveryDate(requestShipment.getEstimateDeliveryDate())
                .trackingNumber(requestShipment.getTrackingNumber())
                .shippingMethod(requestShipment.getShippingMethod())
                .build();
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
