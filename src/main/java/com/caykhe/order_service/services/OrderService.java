package com.caykhe.order_service.services;

import com.caykhe.order_service.dtos.ApiException;
import com.caykhe.order_service.dtos.RequestOrder;
import com.caykhe.order_service.models.Order;
import com.caykhe.order_service.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    final OrderRepository orderRepository;

    public Optional<Order> getOrderById(String id) {

        return orderRepository.findById(id);
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order createOrder(RequestOrder request) {
        Order newOrder = Order.builder()
                .userId(request.getUserId())
                .orderDate(request.getOrderDate())
                .totalAmount(request.getTotalAmount())
                .build();
        return orderRepository.save(newOrder);
    }

    public Order updateOrder(String id, RequestOrder requestUpdate) throws Exception {

        Optional<Order> OrderOptional = orderRepository.findById(id);

        if (OrderOptional.isPresent()) {
            Order order = OrderOptional.get();
            order.setOrderDate(new Date());
            order.setUserId(requestUpdate.getUserId());
            order.setTotalAmount(requestUpdate.getTotalAmount());
            orderRepository.save(order);
            return order;
        } else {
            throw new Exception("Error");
        }
    }
    public Boolean CheckOrder(String id){
        return this.getOrderById(id).isPresent();
    }
    public void deleteById(String id) {
        if (!CheckOrder(id))
            throw new ApiException("Không tìm thấy sản phẩm", HttpStatus.NOT_FOUND);
        else {
            Optional<Order> userOptional = getOrderById(id);
            userOptional.ifPresent(orderRepository::delete);
        }
    }

}
