package com.faznifarook.dispatch;

import com.faznifarook.dispatch.entity.Dispatch;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/dispatch")
@AllArgsConstructor
public class DispatchController {
    private final DispatchRepository dispatchRepository;
    private final DispatchService dispatchService;

    @CrossOrigin(origins = "http://localhost:4201")
    @PostMapping("/update-dispatch")
    public void placeOrder(@RequestBody DispatchOrderRequest dispatchOrderRequest){
        log.info("New Order has been Placed {}",dispatchOrderRequest.id());
        Integer id = dispatchOrderRequest.id();
        Boolean isDispatch = dispatchOrderRequest.isdispatch();
        Dispatch dispatch = dispatchRepository.getOne(id);
        if(isDispatch == false){
            dispatch.setStatus("Order Dispatched");
            dispatch.setIsDispatched(true);
            dispatchRepository.save(dispatch);
        }
        log.info("New Order has been Placed {}",id);
    }

    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping("/get-all")
    public List<Dispatch> getOrders(){
        return dispatchRepository.findAllByIdDESC();
    }
}
