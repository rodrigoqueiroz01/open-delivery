package com.github.dev.orders.domain.model;

import com.github.dev.orders.domain.enums.NameType;
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
public class SponsorshipValue implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private NameType name;
    private Price amount;

}

