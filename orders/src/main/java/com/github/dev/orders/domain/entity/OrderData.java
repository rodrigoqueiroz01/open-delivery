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
@Table(name = "order_data", schema = "public")
public class OrderData implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "merchant_id")
    public UUID merchantId;

    @Column(name = "source_app_id")
    public String sourceAppId;

    @Column
    public String data;

}
