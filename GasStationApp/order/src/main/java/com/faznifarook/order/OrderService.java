package com.faznifarook.order;

public record OrderService() {
    public void placeOrder(OrderRequest orderRequest) {
        Order order = Order.builder().allocAmount(orderRequest.allocAmount()).build();
//        todo : check the allocation is available or not
    }
}
