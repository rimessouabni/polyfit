package com.polyfit.polyfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.polyfit.polyfit.model.Workout;
import com.polyfit.polyfit.repository.WorkoutRepository;

import java.util.List;

@RestController
public class WorkoutController {

    @Autowired
    private WorkoutRepository workoutRepository;

    @GetMapping("/get-all-workouts")
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    @GetMapping("/get-workout/{id}")
    public Workout getSingleWorkout(@PathVariable("id") Long id) {
        return workoutRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/remove-workout/{id}")
    public boolean deleteWorkout(@PathVariable("id") Long id) {
        if (workoutRepository.existsById(id)) {
            workoutRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/update-workout/{id}")
    public Workout updateWorkout(@PathVariable("id") Long id, @RequestBody Workout updatedWorkout) {
        Workout currentWorkout = workoutRepository.findById(id).orElse(null);
        if (currentWorkout != null) {
            // Update workout attributes
            currentWorkout.setTitle(updatedWorkout.getTitle());
            currentWorkout.setDescription(updatedWorkout.getDescription());
            // Save the updated workout
            workoutRepository.save(currentWorkout);
        }
        return currentWorkout;
    }

    @PostMapping("/add-workout")
    public Workout createWorkout(@RequestBody Workout newWorkout) {
        return workoutRepository.save(newWorkout);
    }
}
