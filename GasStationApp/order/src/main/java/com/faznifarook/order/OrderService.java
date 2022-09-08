package com.faznifarook.order;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    KafkaTemplate<String,Order> kafkaTemplate;
    public void placeOrder(OrderRequest orderRequest) {

        Order order = Order.builder()
                .status("Order Created")
                .createdAt(LocalDateTime.now())
                .allocAmount(orderRequest.allocAmount())
                .build();
//        todo: check the allocation is available or not
//      sending the order details to allocation service to check weather stock is available or not
        Message<Order> message = MessageBuilder.withPayload(order)
                .setHeader(KafkaHeaders.TOPIC,"mainTopic")
                        .build();
        //  Storing to database
        orderRepository.save(order);
        //  Sending to kafka Topic
        kafkaTemplate.send(message);
    }

//    public void getOrder(List<Order> orderList) {
//        for (int i=0; i<=orderList.size(); i++){
//            Order o = orderList.get(i);
//        }
//    }

//    public Order findOrder(Integer id){
//        Optional<Order> orderResponse = orderRepository.findById(id);
//        Order order = orderResponse.get();
//        return order;
//    }
}
