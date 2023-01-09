package com.github.dev.orders.domain.model;

import com.github.dev.orders.domain.enums.IndoorMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderIndoor implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private IndoorMode mode;
    private LocalDateTime indoorDateTime;
    private String place;

}
