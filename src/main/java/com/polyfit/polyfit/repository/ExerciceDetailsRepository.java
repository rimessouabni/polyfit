package com.polyfit.polyfit.repository;

import com.polyfit.polyfit.model.ExerciceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciceDetailsRepository extends JpaRepository<ExerciceDetails, com.polyfit.polyfit.model.ExerciceDetailsId> {
    // Add custom query methods if needed
}
