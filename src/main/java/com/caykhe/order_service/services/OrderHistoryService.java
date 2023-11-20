package com.caykhe.order_service.services;

import com.caykhe.order_service.models.OrderHistory;
import com.caykhe.order_service.repositories.OrderHistoryRepository;
import lombok.RequiredArgsConstructor;
import com.caykhe.order_service.dtos.RequestOrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderHistoryService {

    private final OrderHistoryRepository orderHistoryRepository;

    public List<OrderHistory> getAllOrderHistories() {
        return orderHistoryRepository.findAll();
    }

    public OrderHistory getOrderHistoryById(String orderHistoryId) {
        return orderHistoryRepository.findById(orderHistoryId).orElse(null);
    }

    public OrderHistory createOrderHistory(OrderHistory orderHistory) {
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

