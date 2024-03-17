package com.polyfit.polyfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.polyfit.polyfit.model.TrainingProgram;
import com.polyfit.polyfit.services.TrainingProgramService;

import java.util.List;

@RestController
public class TrainingProgramController {

    @Autowired
    private TrainingProgramService trainingProgramService;

    @GetMapping("/training-programs")
    public List<TrainingProgram> getAllTrainingPrograms() {
        return trainingProgramService.getAllTrainingPrograms();
    }

    @GetMapping("/training-programs/{id}")
    public TrainingProgram getTrainingProgramById(@PathVariable("id") Long id) {
        return trainingProgramService.getTrainingProgramById(id);
    }

    @PostMapping("/training-programs")
    public TrainingProgram createTrainingProgram(@RequestBody TrainingProgram program) {
        return trainingProgramService.createTrainingProgram(program);
    }

    @PutMapping("/training-programs/{id}")
    public TrainingProgram updateTrainingProgram(@PathVariable("id") Long id, @RequestBody TrainingProgram program) {
        return trainingProgramService.updateTrainingProgram(id, program);
    }

    @DeleteMapping("/training-programs/{id}")
    public void deleteTrainingProgram(@PathVariable("id") Long id) {
        trainingProgramService.deleteTrainingProgram(id);
    }
}
