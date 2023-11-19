package com.caykhe.order_service.services;

import com.caykhe.order_service.models.OrderItem;
import com.caykhe.order_service.repositories.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;


    public List<OrderItem> getAllOrder() {
        return orderItemRepository.findAll();
    }


}
