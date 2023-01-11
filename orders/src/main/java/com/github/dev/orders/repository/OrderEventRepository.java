package com.github.dev.orders.repository;

import com.github.dev.orders.domain.entity.EventData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderEventRepository extends JpaRepository<EventData, UUID> {

    EventData getByIdAndSourceAppId(UUID id, UUID sourceAppId);

    List<EventData> findByAckAtIsNotOrderBySourceAppId(UUID sourceAppId);

}
