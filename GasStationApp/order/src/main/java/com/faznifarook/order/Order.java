package com.faznifarook.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// order class
@Data
@Builder
//@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Order")
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_id_sequence",
            sequenceName = "order_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_id_sequence"
    )
    private Long orderId;
    private Integer allocAmount;
    private String status;

    public Order(Long orderId,
                 Integer allocAmount,
                 String status) {
        this.orderId = orderId;
        this.allocAmount = allocAmount;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getAllocAmount() {
        return allocAmount;
    }

    public void setAllocAmount(Integer allocAmount) {
        this.allocAmount = allocAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", allocAmount=" + allocAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
