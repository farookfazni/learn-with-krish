package com.faznifarook.allocation;

import com.faznifarook.allocation.entity.AllocationCheckHistory;
import com.faznifarook.allocation.entity.Order;
import com.faznifarook.allocation.repo.AllocationCheckHistoryRepositry;
import com.faznifarook.allocation.repo.OrderRepository;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// In Here We Save the Values To the Database
@Service
@AllArgsConstructor
public class AllocationCheckService {

    private final AllocationCheckHistoryRepositry allocationCheckHistoryRepositry;
    @Autowired
    private final OrderRepository orderRepository;
// todo: Need check Whether Stock is avilable or not
    @KafkaListener(topics = "mainTopic", groupId = "groupId")
    public void listenerForOrder (String data) { //todo: AllocaionCheckResponce allocaionCheckResponce
        Gson g = new Gson();
        Order o = g.fromJson(data,Order.class);
        System.out.println("Listener received json: " + o);
        AllocationCheckHistory allocationCheckHistory = AllocationCheckHistory
                .builder()
                .orderId(o.getOrderId())
                .allocAmmount(o.getAllocAmount())
                .status(o.getStatus())
                .createdAt(LocalDateTime.now())
                .isStockAvailable(true)    // todo: allocaionCheckResponce.isStockAvailable()
                .build();
        orderRepository.save(o);
        allocationCheckHistoryRepositry.save(allocationCheckHistory);
    }
//    public void placeCheck(MessageRequest messageRequest){
//        AllocationCheckHistory allocationCheckHistory = AllocationCheckHistory
//                .builder()
//                .orderId(messageRequest.)
//                .build();
//    }
}
