package com.caykhe.order_service.services;

import com.caykhe.order_service.dtos.RequestOrderItem;
import com.caykhe.order_service.models.OrderItem;
import com.caykhe.order_service.repositories.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;


    public List<OrderItem> getAllOrder(){
        return orderItemRepository.findAll();}


}
