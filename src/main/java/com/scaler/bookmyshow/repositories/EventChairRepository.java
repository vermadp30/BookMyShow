package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Chair;
import com.scaler.bookmyshow.models.Event;
import com.scaler.bookmyshow.models.EventChair;
import jakarta.persistence.LockModeType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

@Repository
public interface EventChairRepository extends JpaRepository<EventChair,Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<EventChair> findAllByChairInAndEvent(List<Chair> chairs, Event event);

    EventChair save(EventChair eventChair);
}
