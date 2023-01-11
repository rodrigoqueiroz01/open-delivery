package com.github.dev.orders.service;

import com.github.dev.orders.domain.entity.OrderData;
import com.github.dev.orders.domain.model.Order;
import com.github.dev.orders.domain.model.OrderConfirm;
import com.github.dev.orders.exception.EntityNotFoundException;
import com.github.dev.orders.repository.OrderRepository;
import com.github.dev.orders.util.JsonUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderEventService eventService;

    public Order save(Order order) throws Exception {
        order.setCreatedAt(LocalDateTime.now());

        var orderData = OrderData.builder()
                .id(order.getId())
                .createdAt(Date.from(order.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant()))
                .merchantId(order.getMerchant().getId())
                .data(JsonUtil.asJson(order))
                .build();

        orderRepository.save(orderData);

        List<String> appsId = Arrays.asList("lkdjflsjfdslkfjsdl");
        for (String sourceAppId : appsId) {
            eventService.orderCreate(order.getId(), sourceAppId);
        }

        return findById(order.getId());
    }

    public Order findById(UUID id) throws Exception {
        var data = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The requested resource was not found."));

        return JsonUtil.asObject(data.data, Order.class);
    }

    public void confirm(UUID orderId, OrderConfirm confirm) {
        var order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("The requested resource was not found."));

        // TODO salvar confirm.getOrderExternalCode() em alguma tabela de mapeamento.

        List<String> appsId = Arrays.asList("lkdjflsjfdslkfjsdl");
        for (String sourceAppId : appsId) {
            eventService.orderConfirm(orderId, sourceAppId);
        }
    }

    public void readyForPickup(UUID orderId) {
        var order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("The requested resource was not found."));

        List<String> appsId = Arrays.asList("lkdjflsjfdslkfjsdl");
        for (String sourceAppId : appsId) {
            eventService.orderReadyForPickup(orderId, sourceAppId);
        }
    }

    public void dispatch(UUID orderId) {
        var order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("The requested resource was not found."));

        List<String> appsId = Arrays.asList("lkdjflsjfdslkfjsdl");
        for (String sourceAppId : appsId) {
            eventService.orderDispatch(orderId, sourceAppId);
        }
    }

}
