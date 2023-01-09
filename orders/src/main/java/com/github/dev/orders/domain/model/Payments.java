package com.github.dev.orders.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payments implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private Double prepaid;
    private Double pending;
    private List<Method> methods;

}


