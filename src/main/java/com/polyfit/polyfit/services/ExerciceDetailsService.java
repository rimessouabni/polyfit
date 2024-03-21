package com.polyfit.polyfit.services;

import com.polyfit.polyfit.model.ExerciceDetails;
import com.polyfit.polyfit.model.ExerciceDetailsId;
import com.polyfit.polyfit.repository.ExerciceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExerciceDetailsService {

    @Autowired
    private ExerciceDetailsRepository exerciceDetailsRepository;

    public Optional<ExerciceDetails> getExerciceDetails(String exerciceTitle, Long workoutId) {
        ExerciceDetailsId exerciceDetailsId = new ExerciceDetailsId();
        exerciceDetailsId.setExercice(exerciceTitle);
        exerciceDetailsId.setWorkout(workoutId);
        return exerciceDetailsRepository.findById(exerciceDetailsId);
    }

    // Other service methods (delete, update, create) can be similarly implemented
}
