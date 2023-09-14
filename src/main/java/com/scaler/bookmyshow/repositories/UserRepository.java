package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long userId);

    @Override
    User save(User user);
}
