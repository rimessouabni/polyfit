package com.polyfit.polyfit.controller;

import com.polyfit.polyfit.model.ExerciceDetails;
import com.polyfit.polyfit.model.ExerciceDetailsId;
import com.polyfit.polyfit.repository.ExerciceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExerciceDetailsController {

    @Autowired
    private ExerciceDetailsRepository exerciceDetailsRepository;

    @GetMapping("/exercice-details/{exerciceTitle}/{workoutId}")
    public ExerciceDetails getExerciceDetails(@PathVariable("exerciceTitle") String exerciceTitle,
                                              @PathVariable("workoutId") Long workoutId) {
        ExerciceDetailsId exerciceDetailsId = new ExerciceDetailsId();
        exerciceDetailsId.setExercice(exerciceTitle);
        exerciceDetailsId.setWorkout(workoutId);
        return exerciceDetailsRepository.findById(exerciceDetailsId).orElse(null);
    }

    @DeleteMapping("/exercice-details/{exerciceTitle}/{workoutId}")
    public boolean deleteExerciceDetails(@PathVariable("exerciceTitle") String exerciceTitle,
                                         @PathVariable("workoutId") Long workoutId) {
        ExerciceDetailsId exerciceDetailsId = new ExerciceDetailsId();
        exerciceDetailsId.setExercice(exerciceTitle);
        exerciceDetailsId.setWorkout(workoutId);
        if (exerciceDetailsRepository.existsById(exerciceDetailsId)) {
            exerciceDetailsRepository.deleteById(exerciceDetailsId);
            return true;
        }
        return false;
    }

    // Other CRUD operations (update, create) can be similarly implemented
}
