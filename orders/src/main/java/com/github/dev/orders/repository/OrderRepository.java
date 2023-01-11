package com.github.dev.orders.repository;

import com.github.dev.orders.domain.entity.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderData, UUID> { }
