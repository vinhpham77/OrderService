package com.caykhe.order_service.services;

import com.caykhe.order_service.dtos.ApiException;
import com.caykhe.order_service.dtos.RequestOrderItem;
import com.caykhe.order_service.models.Order;
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

    final OrderItemRepository orderItemRepository;
    final OrderService orderService;

    public Optional<OrderItem> getOrderItemById(String id) {
        return orderItemRepository.findById(id);
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem createOrderItem(RequestOrderItem request) {
       if(orderService.CheckOrder(request.getOrderId())){
           OrderItem newOrderItem = OrderItem.builder()
                   .orderId(request.getOrderId())
                   .productId(request.getProductId())
                   .quantity(request.getQuantity())
                   .price(request.getPrice())
                   .build();
           return orderItemRepository.save(newOrderItem);
       }
       else
           throw new ApiException("Không tìm thấy Order id", HttpStatus.NOT_FOUND);

    }

    public OrderItem updateOrderItem(String id, RequestOrderItem requestUpdate) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(id);

        if (orderItemOptional.isPresent()) {
            OrderItem orderItem = orderItemOptional.get();
            orderItem.setOrderId(requestUpdate.getOrderId());
            orderItem.setProductId(requestUpdate.getProductId());
            orderItem.setQuantity(requestUpdate.getQuantity());
            orderItem.setPrice(requestUpdate.getPrice());
            orderItemRepository.save(orderItem);
            return orderItem;
        } else {
            throw new ApiException("Không thấy chi tiết sản phẩm",HttpStatus.NOT_FOUND);
        }
    }

    public Boolean checkOrderItem(String id) {
        return this.getOrderItemById(id).isPresent();
    }

    public void deleteById(String id) {
        if (!checkOrderItem(id))
            throw new ApiException("Không tìm thấy chi sản phẩm", HttpStatus.NOT_FOUND);
        else {
            Optional<OrderItem> orderItemOptional = getOrderItemById(id);
            orderItemOptional.ifPresent(orderItemRepository::delete);
        }
    }





}
