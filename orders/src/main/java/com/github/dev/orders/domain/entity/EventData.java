package com.github.dev.orders.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event_data", schema = "public")
public class EventData implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @Column(name = "source_app_id", nullable = false)
    private UUID sourceAppId;

    @Column(name = "order_id", nullable = false)
    private UUID orderId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column
    public String data;

    @Column(name = "ack_at")
    private Date ackAt;

}

