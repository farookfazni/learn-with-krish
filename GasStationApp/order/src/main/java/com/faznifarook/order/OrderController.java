package com.faznifarook.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller Class of Order
@Slf4j
@RestController
@RequestMapping("api/v1/orders")
public record OrderController(OrderService orderService) {

    @PostMapping
    public void placeOrder(@RequestBody OrderRequest orderRequest){
        log.info("New Order has been Placed {}",orderRequest);
        orderService.placeOrder(orderRequest);
    }
}
