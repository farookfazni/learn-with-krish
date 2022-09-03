package com.faznifarook.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

// Allocation Class where we define our variables of the class
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllocationCheckHistory {
    @Id
    private Long id;
    private Integer orderId;
    private Integer allocAmmount;
    private String status;
    private Boolean isStockAvailable;
    private ArrayList createdAt;

}
