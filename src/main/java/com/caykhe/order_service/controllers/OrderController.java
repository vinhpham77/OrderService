package com.caykhe.order_service.controllers;

import com.caykhe.order_service.dtos.ApiException;
import com.caykhe.order_service.dtos.RequestOrder;
import com.caykhe.order_service.models.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.caykhe.order_service.services.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id)
                .map(order -> new ResponseEntity<>(order, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrder();
    }
    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody RequestOrder requestOrder) {
        return ResponseEntity.ok(orderService.createOrder(requestOrder));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable String id, @RequestBody Order requestUpdate) throws Exception {
        if(orderService.CheckOrder(id)) {
            Order updatedOrder = orderService.updateOrder(id, requestUpdate);
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        }
        throw new ApiException("Không tìm thấy Order",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        if(orderService.CheckOrder(id)) {
            orderService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
     throw new ApiException("Không tìm thấy",HttpStatus.NOT_FOUND);
        }
    }


