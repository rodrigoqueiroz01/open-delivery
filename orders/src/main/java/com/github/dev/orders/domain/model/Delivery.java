package com.github.dev.orders.domain.model;

import com.github.dev.orders.domain.enums.DeliveredBy;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Delivery implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private DeliveredBy deliveredBy;
    private DeliveryAddress deliveryAddress;
    private LocalDateTime estimatedDeliveryDateTime;
    private LocalDateTime deliveryDateTime;

}
