package com.faznifarook.allocation;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

// In Here We Save the Values To the Database
@Service
@AllArgsConstructor
public class AllocationCheckService {

//    private final AllocationCheckHistoryRepositry allocationCheckHistoryRepositry;
//
//    @Autowired
//    private final OrderRepository orderRepository;
//
//    @KafkaListener(topics = "mainTopic", groupId = "groupId")
//    public void listener (String data) {
//        Gson g = new Gson();
//        Order o = g.fromJson(data,Order.class);
//        System.out.println("Listener received json: " + o);
//        orderRepository.save(o);
//    }

//    @KafkaListener(topics = "mainTopic", groupId = "groupId")
//    public boolean isStockAvailable(Integer orderID){
//        allocationCheckHistoryRepositry.save(
//                AllocationCheckHistory.builder()
//                        .orderId(orderID)
//                        .isStockAvailable(true)
//                        .createdAt(LocalDateTime.now())
//                        .build()
//        );
//        return true;
//    }

}
