package com.github.dev.orders.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private UUID id;
    private Phone phone;
    private String documentNumber;
    private String name;
    private Double ordersCountOnMerchant;

}
