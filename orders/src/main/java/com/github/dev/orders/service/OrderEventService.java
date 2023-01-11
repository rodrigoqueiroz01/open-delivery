package com.github.dev.orders.service;

import com.github.dev.orders.domain.entity.EventData;
import com.github.dev.orders.domain.enums.EventType;
import com.github.dev.orders.domain.model.Event;
import com.github.dev.orders.repository.OrderEventRepository;
import com.github.dev.orders.repository.OrderRepository;
import com.github.dev.orders.util.JsonUtil;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
@AllArgsConstructor
public class OrderEventService {

    private final OrderEventRepository eventRepository;
    private final OrderRepository orderRepository;

    @Async
    public Event orderCreate(UUID orderId, String sourceAppId) {
        var event = Event.builder()
                .eventType(EventType.CREATED)
                .orderId(orderId)
                .sourceAppId(UUID.fromString(sourceAppId))
                .build();

        return save(event);
    }

    @Async
    public Event orderConfirm(UUID orderId, String sourceAppId) {
        var event = Event.builder()
                .eventType(EventType.CONFIRMED)
                .orderId(orderId)
                .sourceAppId(UUID.fromString(sourceAppId))
                .build();

        return save(event);
    }

    @Async
    public Event orderCancel(UUID orderId, UUID sourceAppId) throws Exception {
        var event = Event.builder()
                .eventType(EventType.CANCELLED)
                .orderId(orderId)
                .sourceAppId(sourceAppId)
                .build();

        return save(event);
    }

    @Async
    public Event orderReadyForPickup(UUID orderId, String sourceAppId) {
        var event = Event.builder()
                .eventType(EventType.READY_FOR_PICKUP)
                .orderId(orderId)
                .sourceAppId(UUID.fromString(sourceAppId))
                .build();

        return save(event);
    }

    @Async
    public Event orderDispatch(UUID orderId, String sourceAppId) {
        var event = Event.builder()
                .eventType(EventType.DISPATCHED)
                .orderId(orderId)
                .sourceAppId(UUID.fromString(sourceAppId))
                .build();

        return save(event);
    }

    public Event save(Event event) {
        if (event.getEventId() == null) {
            event.setEventId(UUID.fromString(UUID.randomUUID().toString()));
        }

        if (event.getCreatedAt() == null) {
            event.setCreatedAt(LocalDateTime.now());
        }

        var eventData = EventData.builder()
                .id(event.getEventId())
                .orderId(event.getOrderId())
                .sourceAppId(event.getSourceAppId())
                .createdAt(Date.from(event.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant()))
                .data(JsonUtil.asJson(event))
                .build();

        eventRepository.save(eventData);
        return event;
    }

    public boolean ack(UUID orderId, String sourceAppId) {
        var eventData = eventRepository.getByIdAndSourceAppId(orderId, UUID.fromString(sourceAppId));

        if (!Objects.nonNull(eventData)) {
            eventData.setAckAt(new Date());
            eventRepository.save(eventData);
            return true;
        }

        return false;
    }

    public List<Event> getNotAckEventsBySourceApp(String sourceAppId) {
        List<Event> events = new ArrayList<>();
        List<EventData> eventsData = eventRepository.findByAckAtIsNotOrderBySourceAppId(UUID.fromString(sourceAppId));

        if (Objects.nonNull(eventsData)) {
            for (var eventData : eventsData) {
                events.add(JsonUtil.asObject(eventData.getData(), Event.class));
            }
        }

        return events;
    }

}
