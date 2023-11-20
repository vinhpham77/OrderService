package com.caykhe.order_service.services;

import com.caykhe.order_service.models.Order;
import com.caykhe.order_service.models.OrderHistory;
import com.caykhe.order_service.repositories.OrderHistoryRepository;
import lombok.RequiredArgsConstructor;
import com.caykhe.order_service.dtos.RequestOrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderHistoryService {

    private final OrderHistoryRepository orderHistoryRepository;
    private final OrderService orderService;

    public List<OrderHistory> getAllOrderHistories() {
        return orderHistoryRepository.findAll();
    }

    public OrderHistory getOrderHistoryById(String orderHistoryId) {
        return orderHistoryRepository.findById(orderHistoryId)
                .orElseThrow(() -> new UsernameNotFoundException("OrderHistory not found"));
    }

    public OrderHistory createOrderHistory(RequestOrderHistory requestOrderHistory) {
        Order order = orderService.getOrderById(requestOrderHistory.getOrderId())
                .orElseThrow(() -> new UsernameNotFoundException("Order not found"));
        OrderHistory orderHistory = OrderHistory.builder()
                .orderId(requestOrderHistory.getOrderId())
                .status(requestOrderHistory.getStatus())
                .updateAt(requestOrderHistory.getUpdateAt())
                .build();
        return orderHistoryRepository.save(orderHistory);
    }

    public OrderHistory updateOrderHistory(String orderHistoryId, RequestOrderHistory updatedOrderHistory) throws Exception {
        Optional<OrderHistory> orderHistoryOptional = orderHistoryRepository.findById(orderHistoryId);

        if (orderHistoryOptional.isPresent()) {
            OrderHistory orderHistory = orderHistoryOptional.get();
            orderHistory.setOrderId(updatedOrderHistory.getOrderId());
            orderHistory.setStatus(updatedOrderHistory.getStatus());
            orderHistory.setUpdateAt(updatedOrderHistory.getUpdateAt());
            return orderHistoryRepository.save(orderHistory);
        } else {
            throw new Exception("OrderHistory not found");
        }
    }

    public void deleteOrderHistory(String orderHistoryId) {
        orderHistoryRepository.deleteById(orderHistoryId);
    }
}

