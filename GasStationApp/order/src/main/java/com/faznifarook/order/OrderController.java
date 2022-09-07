package com.faznifarook.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller Class of Order
@Slf4j
@RestController
@RequestMapping("api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;
//    @Autowired KafkaTemplate<String,Order> kafkaTemplate;

    @PostMapping("/data")
    public void placeOrder(@RequestBody OrderRequest orderRequest){
        log.info("New Order has been Placed {}",orderRequest);
        orderService.placeOrder(orderRequest);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get-all")
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }


//    @PostMapping(value = "/send")
//    public String sendMessage(@RequestBody Order order){
//////        Sending to kafka Topic
//
//        kafkaTemplate.send("mainTopic", order);
//        return "Message Sent";
//    }

}
