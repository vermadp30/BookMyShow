package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Chair;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChairRepository extends JpaRepository<Chair, Long> {

    List<Chair> findAllByIdIn(Iterable<Long> seatIds);

    List<Chair> findAllByIdAndColz(Long id,Long col);
}
