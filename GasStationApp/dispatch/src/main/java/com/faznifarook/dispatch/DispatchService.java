package com.faznifarook.dispatch;

import com.faznifarook.dispatch.entity.Dispatch;
import com.faznifarook.dispatch.entity.Schedule;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DispatchService {
//    todo: Need To Find a Way To make the Order Dispatch on the Scheduled date
    private final DispatchRepository dispatchRepository;
//    private final  DispatchOrderRequest dispatchOrderRequest;

    @KafkaListener(topics = "thirdTopic", groupId = "groupId")
    public void dispatchOrder(String data){
        Gson g = new Gson();
        Schedule a = g.fromJson(data,Schedule.class);

//      Getting the Scheduled Date
        List<Integer> scdate = a.getScheduleTime();
        LocalDateTime scheduledTime =LocalDateTime.of(scdate.get(0),scdate.get(1),scdate.get(2), scdate.get(3),scdate.get(4),scdate.get(5),scdate.get(6));
        System.out.println(scheduledTime);
//      Checking Whether the order can be dispatched or not
//      Updating the Status According to the Check
        Boolean isDispatched = isDispatched(scheduledTime);

        Dispatch dispatch = Dispatch.builder()
                .orderId(a.getOrderId())
                .allocAmount(a.getAllocAmount())
                .createdAt(LocalDateTime.now())
                .dispatchAt(scheduledTime)
                .isDispatched(isDispatched)
                .status(checkStatus(isDispatched))
                .build();
        dispatchRepository.save(dispatch);
    }
    public Boolean isDispatched(LocalDateTime scheduledTime){
        if (LocalDateTime.now()== scheduledTime){
            return true;
        }else {
            return false;
        }
    }

    public String checkStatus(Boolean isDispatched){
        if (isDispatched == true){
            return "Order Dispatched";
        }else {
            return "Order Not Dispatched";
        }
    }

    public void dispatchOrderAdmin(DispatchOrderRequest dispatchOrderRequest) {
//        if(dispatchOrderRequest.isdispatch() == true){
//            Optional<Dispatch> dt = dispatchRepository.findById(dispatchOrderRequest.id());
//            Dispatch dispatch = dt.get();
//            Dispatch dispatch = Dispatch.builder()
//                    .status("Order Dispatched")
//                    .build();
//            dispatch.setStatus("Order Dispatched");
//            dispatch.setIsDispatched(true);
            log.info("dispatch",dispatchOrderRequest);
//            dispatchRepository.save(dispatch);
//            return "Order Dispatched";
//        }

    }
}
