package com.polyfit.polyfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polyfit.polyfit.model.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    // You can add custom query methods here if needed
}