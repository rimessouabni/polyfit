package com.polyfit.polyfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polyfit.polyfit.model.TrainingProgram;

@Repository
public interface TrainingProgramRepository extends JpaRepository<TrainingProgram, Long> {
    // Ajoutez les méthodes de recherche personnalisées au besoin
}
