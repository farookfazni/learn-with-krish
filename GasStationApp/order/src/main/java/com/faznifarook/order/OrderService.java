package com.faznifarook.order;

import org.springframework.stereotype.Service;

@Service
public record OrderService(OrderRepository orderRepository) {
    public void placeOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .status(orderRequest.status())
                .allocAmount(orderRequest.allocAmount())
                .build();
//        todo : check the allocation is available or not
        orderRepository.save(order);
    }
}
