package com.github.dev.orders.domain.model;

import com.github.dev.orders.domain.enums.OrderTiming;
import com.github.dev.orders.domain.enums.OrderType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private UUID id;
    private OrderType type;
    private UUID displayId;
    private UUID sourceAppId;
    private LocalDateTime createdAt;
    private OrderTiming orderTiming;
    private LocalDateTime preparationStartDateTime;
    private OrderMerchant merchant;
    private List<OrderItem> items;
    private List<OtherFee> otherFees;
    private List<Discount> discount;
    private OrderTotal total;
    private Payments payments;
    private Customer customer;
    private OrderSchedule schedule;
    private Delivery delivery;
    private OrderTakeout takeout;
    private OrderIndoor indoor;
    private String extraInfo;

}
