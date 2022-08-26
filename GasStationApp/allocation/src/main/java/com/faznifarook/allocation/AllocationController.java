package com.faznifarook.allocation;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/allocation-check")
@AllArgsConstructor
public class AllocationController {

    private final AllocationCheckService allocationCheckService;

    @GetMapping(path = "{orderId}")
    public AllocaionCheckResponce isStockAvailable(
            @PathVariable("orderId") Long orderId){

        boolean isStockAvailable = allocationCheckService.isStockAvailable(orderId);
        return new AllocaionCheckResponce(isStockAvailable);

    }
}
