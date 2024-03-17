package com.polyfit.polyfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polyfit.polyfit.model.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}
