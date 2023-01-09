package com.github.dev.orders.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private UUID id;
    private Integer index;
    private String name;
    private String externalCode;
    private String unit;
    private String ean;
    private Integer quantity;
    private String specialInstructions;
    private Price unitPrice;
    private Price optionsPrice;
    private Price totalPrice;
    private List<OrderItem> options;

}
