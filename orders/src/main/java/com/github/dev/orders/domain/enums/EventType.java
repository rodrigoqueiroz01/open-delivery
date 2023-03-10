package com.github.dev.orders.domain.enums;

public enum EventType {
    CREATED,
    CONFIRMED,
    DISPATCHED,
    READY_FOR_PICKUP,
    PICKUP_AREA_ASSIGNED,
    CONCLUDED,
    CANCELLATION_REQUESTED,
    CANCELLATION_REQUEST_DENIED,
    CANCELLED,
    ORDER_CANCELLATION_REQUEST;
}
