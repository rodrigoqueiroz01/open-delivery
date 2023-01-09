package com.github.dev.orders.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderConfirm {

    private String reason;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String orderExternalCode;

}


