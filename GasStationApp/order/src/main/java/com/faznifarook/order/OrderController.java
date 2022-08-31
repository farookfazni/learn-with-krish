package com.faznifarook.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller Class of Order
@Slf4j
@RestController
@RequestMapping("api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
//    @Autowired KafkaTemplate<String,Order> kafkaTemplate;

    @PostMapping("/data")
    public void placeOrder(@RequestBody OrderRequest orderRequest){
        log.info("New Order has been Placed {}",orderRequest);
        orderService.placeOrder(orderRequest);
    }


//    @PostMapping(value = "/send")
//    public String sendMessage(@RequestBody Order order){
//////        Sending to kafka Topic
//
//        kafkaTemplate.send("mainTopic", order);
//        return "Message Sent";
//    }

}
