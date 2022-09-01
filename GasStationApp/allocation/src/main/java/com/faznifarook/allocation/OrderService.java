package com.faznifarook.allocation;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;

        @KafkaListener(topics = "mainTopic", groupId = "groupId")
        public void listener (String data) {
            Gson g = new Gson();
            Order o = g.fromJson(data,Order.class);
            System.out.println("Listener received json: " + o);
            orderRepository.save(o);
        }
}
