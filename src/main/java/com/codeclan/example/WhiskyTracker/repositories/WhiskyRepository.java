package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
    List<Whisky> findByDistilleryRegion(String region);

    List<Whisky> findWhiskiesByYear(int i);

    List<Whisky> findByAgeAndDistilleryId(int age, Long id);
}
