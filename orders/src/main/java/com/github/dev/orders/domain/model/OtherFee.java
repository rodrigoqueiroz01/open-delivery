package com.github.dev.orders.domain.model;

import com.github.dev.orders.domain.enums.OtherFeeType;
import com.github.dev.orders.domain.enums.ReicevedByType;
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
public class OtherFee implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private String name;
    private OtherFeeType type;
    private ReicevedByType reicevedBy;
    private String receiverDocument;
    private Price price;
    private String observation;

}
