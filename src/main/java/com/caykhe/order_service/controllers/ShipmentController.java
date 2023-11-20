package com.caykhe.order_service.controllers;

import com.caykhe.order_service.dtos.RequestShipment;
import com.caykhe.order_service.models.Shipment;
import com.caykhe.order_service.services.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {
    @Autowired
    private ShipmentService shipmentService;

    @GetMapping
    public List<Shipment> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @GetMapping("/{shipmentId}")
    public ResponseEntity<Shipment> getShipmentById(@PathVariable String shipmentId) {
        Shipment shipment = shipmentService.getShipmentById(shipmentId);
        return ResponseEntity.ok(shipment);
    }

    @PostMapping("/create")
    public ResponseEntity<Shipment> createShipment(@RequestBody RequestShipment requestShipment) {
        Shipment createdShipment = shipmentService.createShipment(requestShipment);
        return new ResponseEntity<>(createdShipment, HttpStatus.CREATED);
    }

    @PutMapping("/{shipmentId}")
    public ResponseEntity<Shipment> updateShipment(
            @PathVariable String shipmentId,
            @RequestBody RequestShipment updatedShipment
    ) throws Exception {
        Shipment updated = shipmentService.updateShipment(shipmentId, updatedShipment);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{shipmentId}")
    public ResponseEntity<Void> deleteShipment(@PathVariable String shipmentId) {
        shipmentService.deleteShipment(shipmentId);
        return ResponseEntity.noContent().build();
    }
}
