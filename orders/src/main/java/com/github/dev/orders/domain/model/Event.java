package com.github.dev.orders.domain.model;

import com.github.dev.orders.domain.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private UUID eventId;
    private EventType eventType;
    private UUID orderId;
    private String orderURL;
    private LocalDateTime createdAt;
    private UUID sourceAppId;

}
