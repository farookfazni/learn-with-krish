package com.faznifarook.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .status(orderRequest.status())
                .allocAmount(orderRequest.allocAmount())
                .build();
//        todo : check the allocation is available or not
        orderRepository.save(order);
    }
}
