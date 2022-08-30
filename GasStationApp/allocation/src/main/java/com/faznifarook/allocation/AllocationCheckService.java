package com.faznifarook.allocation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// In Here We Save the Values To the Database
@Service
@AllArgsConstructor
public class AllocationCheckService {

    private final AllocationCheckHistoryRepositry allocationCheckHistoryRepositry;

    public boolean isStockAvailable(Long orderID){
        allocationCheckHistoryRepositry.save(
                AllocationCheckHistory.builder()
                        .orderId(orderID)
                        .isStockAvailable(true)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return true;
    }
}