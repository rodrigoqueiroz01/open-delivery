package com.github.dev.orders.domain.model;

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
public class Coordinates implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private Float latitude;
    private Float longitude;

}
