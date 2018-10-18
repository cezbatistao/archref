package com.cit.checkout.usecase;

import com.cit.checkout.domain.Order;
import com.cit.checkout.gateway.OrderGateway;

import java.util.UUID;

public class DetailOrder {

    private OrderGateway orderGateway;

    public DetailOrder(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public Order execute(UUID orderId) {
        return orderGateway.findById(orderId);
    }
}
