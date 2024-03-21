// ExerciceRepository.java
package com.polyfit.polyfit.repository;

import com.polyfit.polyfit.model.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, String> {
}
