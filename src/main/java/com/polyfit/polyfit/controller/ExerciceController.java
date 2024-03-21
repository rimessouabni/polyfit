// ExerciceController.java
package com.polyfit.polyfit.controller;

import com.polyfit.polyfit.model.Exercice;
import com.polyfit.polyfit.repository.ExerciceDetailsRepository;
import com.polyfit.polyfit.repository.ExerciceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class ExerciceController {

    @Autowired
    private ExerciceRepository exerciceRepository;

    @Autowired
    private ExerciceDetailsRepository exerciceDetailsRepository;

    @GetMapping("/exercices")
    public List<Exercice> getAllExercices() {
        return exerciceRepository.findAll();
    }

    @GetMapping("/exercices/{title}")
    public Exercice getSingleExercice(@PathVariable("title") String title) {
        return exerciceRepository.findById(title).orElse(null);
    }

    @DeleteMapping("/exercices/{title}")
    public boolean deleteExercice(@PathVariable("title") String title) {
        if (exerciceRepository.existsById(title)) {
            exerciceRepository.deleteById(title);
            return true;
        }
        return false;
    }

    @PutMapping("/exercices/{title}")
    public Exercice updateExercice(@PathVariable("title") String title, @RequestBody Exercice updatedExercice) {
        Exercice currentExercice = exerciceRepository.findById(title).orElse(null);
        if (currentExercice != null) {
            // Update exercice attributes
            currentExercice.setIconPath(updatedExercice.getIconPath());
            currentExercice.setDescription(updatedExercice.getDescription());
            // Save the updated exercice
            exerciceRepository.save(currentExercice);
        }
        return currentExercice;
    }

    @PostMapping("/exercices")
    public Exercice createExercice(@RequestBody Exercice newExercice) {
        return exerciceRepository.save(newExercice);
    }

    // Endpoints for ExerciceDetails CRUD operations can be added here
}
