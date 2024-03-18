package com.polyfit.polyfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.polyfit.polyfit.model.TrainingProgram;
import com.polyfit.polyfit.repository.TrainingProgramRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/training-programs")
public class TrainingProgramController {

    @Autowired
    private TrainingProgramRepository trainingProgramRepository;

    @GetMapping("/get-all")
    public List<TrainingProgram> getAllTrainingPrograms() {
        return trainingProgramRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public TrainingProgram getSingleTrainingProgram(@PathVariable("id") Long id) {
        return trainingProgramRepository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public TrainingProgram addTrainingProgram(@RequestBody TrainingProgram newProgram) {
        return trainingProgramRepository.save(newProgram);
    }

    @PutMapping("/update/{id}")
    public TrainingProgram updateTrainingProgram(@PathVariable("id") Long id, @RequestBody TrainingProgram updatedProgram) {
        Optional<TrainingProgram> existingProgramOptional = trainingProgramRepository.findById(id);
        if (existingProgramOptional.isPresent()) {
            TrainingProgram existingProgram = existingProgramOptional.get();
            existingProgram.setName(updatedProgram.getName());
            existingProgram.setWorkoutSessions(updatedProgram.getWorkoutSessions());
            return trainingProgramRepository.save(existingProgram);
        } else {
            return null;
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteTrainingProgram(@PathVariable("id") Long id) {
        if (trainingProgramRepository.existsById(id)) {
            trainingProgramRepository.deleteById(id);
            return ResponseEntity.ok("Training program deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Training program not found");
        }
    }
}
