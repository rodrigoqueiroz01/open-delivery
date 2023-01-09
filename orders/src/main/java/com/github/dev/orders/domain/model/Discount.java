package com.github.dev.orders.domain.model;

import com.github.dev.orders.domain.enums.TargetType;
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
public class Discount implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private Price amount;
    private TargetType target;
    private UUID targetId;
    private List<SponsorshipValue> sponsorshipValues;

}


