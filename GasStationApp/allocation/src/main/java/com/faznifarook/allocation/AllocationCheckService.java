package com.faznifarook.allocation;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// In Here We Save the Values To the Database
@Service
@AllArgsConstructor
public class AllocationCheckService {

    private final AllocationCheckHistoryRepositry allocationCheckHistoryRepositry;
    private final OrderRepository orderRepository;

//    @KafkaListener(topics = "mainTopic", groupId = "groupId")
//    public void listener (Order data) {
//
//        Order order = Order.builder()
//                .orderId(data.getOrderId())
//                .allocAmount(data.getAllocAmount())
//                .status(data.getStatus())
//                .build();
//        orderRepository.save(order);
//    }

//    @KafkaListener(topics = "mainTopic", groupId = "groupId")
    public boolean isStockAvailable(Integer orderID){
        allocationCheckHistoryRepositry.save(
                AllocationCheckHistory.builder()
                        .orderId(orderID)
                        .isStockAvailable(true)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return true;
    }

}
