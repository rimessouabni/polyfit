package com.polyfit.polyfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polyfit.polyfit.model.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    Goal findByName(String name);
}
