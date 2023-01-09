package com.github.dev.orders.domain.model;

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
public class OrderSchedule implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private LocalDateTime scheduledDateTimeStart;
    private LocalDateTime scheduledDateTimeEnd;

}

