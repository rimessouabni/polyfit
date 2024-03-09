package com.polyfit.polyfit.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    // Endpoint to get all workouts
    @GetMapping
    public String getAllWorkouts() {
        return "Get all workouts";
    }

    // Endpoint to get a specific workout by ID
    @GetMapping("/{id}")
    public String getWorkoutById(@PathVariable Long id) {
        return "Get workout with ID: " + id;
    }

    // Endpoint to create a new workout
    @PostMapping
    public String createWorkout(@RequestBody String workout) {
        // Logic to create a new workout
        return "Create a new workout: " + workout;
    }

    // Endpoint to update an existing workout
    @PutMapping("/{id}")
    public String updateWorkout(@PathVariable Long id, @RequestBody String workout) {
        // Logic to update the workout with the given ID
        return "Update workout with ID " + id + ": " + workout;
    }

    // Endpoint to delete a workout
    @DeleteMapping("/{id}")
    public String deleteWorkout(@PathVariable Long id) {
        // Logic to delete the workout with the given ID
        return "Delete workout with ID: " + id;
    }
}
