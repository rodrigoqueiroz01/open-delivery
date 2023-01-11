package com.github.dev.orders.controller;

import com.github.dev.orders.domain.model.Event;
import com.github.dev.orders.domain.model.Order;
import com.github.dev.orders.domain.model.OrderConfirm;
import com.github.dev.orders.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Log
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody final Order order) throws Exception {
        log.info("POST /v1/orders/ " + order);
        return ResponseEntity.ok().body(orderService.save(order));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable UUID orderId) throws Exception {
        log.info("GET /v1/orders/ " + orderId);
        return ResponseEntity.ok().body(orderService.findById(orderId));
    }

    @PutMapping("/{orderId}/confirm")
    public ResponseEntity<OrderConfirm> confirm(@PathVariable UUID orderId, @RequestBody(required = false) OrderConfirm orderConfirm) {
        log.info("PUT /v1/orders/" + orderId + "/confirm");
        orderService.confirm(orderId, orderConfirm);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping("/{orderId}/confirm")
    public ResponseEntity<OrderConfirm> confirm2(@PathVariable UUID orderId, @RequestBody(required = false) OrderConfirm orderConfirm) {
        log.info("POST /v1/orders/" + orderId + "/confirm");
        orderService.confirm(orderId, orderConfirm);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/{orderId}/readyForPickup")
    public ResponseEntity<Event> readyForPickup(@PathVariable UUID orderId) {
        log.info("PUT /v1/orders/" + orderId + "/readyForPickup");
        orderService.readyForPickup(orderId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping("/{orderId}/readyForPickup")
    public ResponseEntity<Event> readyForPickup2(@PathVariable UUID orderId) {
        log.info("POST /v1/orders/" + orderId + "/readyForPickup1");
        orderService.readyForPickup(orderId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/{orderId}/dispatch")
    public ResponseEntity<Event> dispatch(@PathVariable UUID orderId) {
        log.info("PUT /v1/orders/" + orderId + "/dispatch");
        orderService.dispatch(orderId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping("/{orderId}/dispatch")
    public ResponseEntity<Event> dispatch2(@PathVariable UUID orderId) {
        log.info("POST /v1/orders/" + orderId + "/dispatch");
        orderService.dispatch(orderId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
