package com.faznifarook.allocation;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

// Allocation Controller Which handles Http Requests
@RestController
@RequestMapping("api/v1/allocation-check")
@AllArgsConstructor
public class AllocationController {

    private final AllocationCheckService allocationCheckService;

    @GetMapping(path = "{orderId}")
    public AllocaionCheckResponce isStockAvailable(
            @PathVariable("orderId") Integer orderId){

        boolean isStockAvailable = allocationCheckService.isStockAvailable(orderId);
        return new AllocaionCheckResponce(isStockAvailable);

    }

//    @PostMapping
//    public void publish(@RequestBody MessageRequest messageRequest){
//        kafkaTemplate.send("mainTopic", messageRequest.message());
//    }
}
