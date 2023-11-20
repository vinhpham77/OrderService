package com.caykhe.order_service.controllers;

import com.caykhe.order_service.dtos.RequestOrderHistory;
import com.caykhe.order_service.models.OrderHistory;
import com.caykhe.order_service.services.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderHistories")
public class OrderHistoryController {

    @Autowired
    private OrderHistoryService orderHistoryService;

    @GetMapping
    public List<OrderHistory> getAllOrderHistories() {
        return orderHistoryService.getAllOrderHistories();
    }

    @GetMapping("/{orderHistoryId}")
    public ResponseEntity<OrderHistory> getOrderHistoryById(@PathVariable String orderHistoryId) {
        OrderHistory orderHistory = orderHistoryService.getOrderHistoryById(orderHistoryId);
        return ResponseEntity.ok(orderHistory);
    }

    @PostMapping("/create")
    public ResponseEntity<OrderHistory> createOrderHistory(@RequestBody RequestOrderHistory requestOrderHistory) {
        OrderHistory createdOrderHistory = orderHistoryService.createOrderHistory(requestOrderHistory);
        return new ResponseEntity<>(createdOrderHistory, HttpStatus.CREATED);
    }

    @PutMapping("/{orderHistoryId}")
    public ResponseEntity<OrderHistory> updateOrderHistory(
            @PathVariable String orderHistoryId,
            @RequestBody RequestOrderHistory updatedOrderHistory
    ) throws Exception {
        OrderHistory updated = orderHistoryService.updateOrderHistory(orderHistoryId, updatedOrderHistory);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{orderHistoryId}")
    public ResponseEntity<Void> deleteOrderHistory(@PathVariable String orderHistoryId) {
        orderHistoryService.deleteOrderHistory(orderHistoryId);
        return ResponseEntity.noContent().build();
    }
}
