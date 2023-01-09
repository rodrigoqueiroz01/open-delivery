package com.github.dev.orders.domain.model;

import com.github.dev.orders.domain.enums.MethodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Method implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private Double value;
    private String currency;
    private Type type;
    private MethodType method;
    private String methodInfo;
    private Double changeFor;

    public enum Type {
        PREPAID,
        PENDING;
    }

}


