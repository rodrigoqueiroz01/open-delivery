package com.github.dev.orders.controller;

import com.github.dev.orders.domain.model.Event;
import com.github.dev.orders.service.OrderEventService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/v1/events")
public class EventController {

    private final OrderEventService eventService;

    @GetMapping(value = "polling")
    public ResponseEntity<List<Event>> getEvents(@RequestHeader("X-API-KEY") String apiKey) throws Exception {
        log.info("GET /v1/events:polling");

        // TODO get sourceAppId pela apiKey
        String sourceAppId = "lkdjflsjfdslkfjsdl"; // fake
        List<Event> events = eventService.getNotAckEventsBySourceApp(sourceAppId);

        if (events.size() > 0) {
            return ResponseEntity.ok().body(events);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping("/acknowledgment")
    public ResponseEntity acknowledgmentEvent(@RequestBody final Event event, @RequestHeader("X-API-KEY") String apiKey) throws Exception {
        log.info("POST /v1/events/acknowledgment");

        // TODO criar DTO EventAck conforme documentação

        // TODO get sourceAppId pela apiKey
        String sourceAppId = "lkdjflsjfdslkfjsdl"; // fake

        if (eventService.ack(event.getEventId(), sourceAppId)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
