package com.caykhe.order_service.controllers;

import com.caykhe.order_service.dtos.RequestOrderItem;
import com.caykhe.order_service.models.OrderItem;
import com.caykhe.order_service.services.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orderItems")
public class OrderItemController {
    private final OrderItemService orderItemService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable String id) {
        return orderItemService.getOrderItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @PostMapping("/create")
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody RequestOrderItem request) {
        OrderItem newOrderItem = orderItemService.createOrderItem(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrderItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable String id, @RequestBody RequestOrderItem requestUpdate) {
        try {
            OrderItem updatedOrderItem = orderItemService.updateOrderItem(id, requestUpdate);
            return ResponseEntity.ok(updatedOrderItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItemById(@PathVariable String id) {
        try {
            orderItemService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
