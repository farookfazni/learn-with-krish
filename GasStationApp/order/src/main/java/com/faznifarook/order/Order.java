package com.faznifarook.order;

import lombok.Builder;
import lombok.Data;

// order class
@Data
@Builder
public class Order {
    private Integer orderId;
    private Integer allocAmount;
    private String status;

}
