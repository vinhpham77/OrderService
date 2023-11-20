package com.caykhe.order_service.services;

import com.caykhe.order_service.models.Order;
import com.caykhe.order_service.models.OrderHistory;
import com.caykhe.order_service.repositories.OrderHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderHistoryService {
    final OrderHistoryRepository orderHistoryRepository;

    public Optional<OrderHistory> getOrderHistoryById(String id) {

        return orderHistoryRepository.findById(id);
    }
//    public List<OrderHistory> getAllOrderHistory(){
//        return orderRepository.findAll();
//    }
}
