package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Event;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    @Override
    Optional<Event> findById(Long eventId);
}
