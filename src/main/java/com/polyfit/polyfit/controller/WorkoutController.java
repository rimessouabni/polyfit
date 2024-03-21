package com.polyfit.polyfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.polyfit.polyfit.model.Workout;
import com.polyfit.polyfit.repository.GoalRepository;
import com.polyfit.polyfit.repository.WorkoutRepository;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class WorkoutController {

    @Autowired
    private WorkoutRepository workoutRepository;
    private GoalRepository goalRepository;
    @GetMapping("/workouts")
    public ModelAndView getWorkoutsPage(Model model) {
        // Logic to fetch data or perform any necessary operations
        // Add any model attributes needed by the template {
            // Récupérer le workout avec l'ID numéro 1 depuis la base de données
        Workout workout = workoutRepository.findById(1L).orElse(null);
        //Goal goal = goalRepository.findById(workout.getGoal()).orElse(null);
        System.out.println(workout.getExerciceDetailsList().get(0).getExercice().getIconPath());
        ModelAndView mav = new ModelAndView("workouts");
        mav.addObject("singleWorkout", workout);
        return mav; // Return the name of the Thymeleaf template
}
    @GetMapping("/workoutss")
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    @GetMapping("/workouts/{id}")
    public Workout getSingleWorkout(@PathVariable("id") Long id) {
        return workoutRepository.findById(id).orElse(null);
    }

    @GetMapping("/workouts/1")
    public String getWorkoutTitle(Model model) {
        // Récupérer le workout avec l'ID numéro 1 depuis la base de données
        Workout workout = workoutRepository.findById(1L).orElse(null);
        System.out.println("heeeeeeerejjjkgkokogkrokokrgorrrrrrrrrleerr");
        model.addAttribute("singleWorkout", workout);
        return "workouts";
    }
    @DeleteMapping("/workouts/{id}")
    public boolean deleteWorkout(@PathVariable("id") Long id) {
        if (workoutRepository.existsById(id)) {
            workoutRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/workouts/{id}")
public Workout updateWorkout(@PathVariable("id") Long id, @RequestBody Workout updatedWorkout) {
    Workout currentWorkout = workoutRepository.findById(id).orElse(null);
    if (currentWorkout != null) {
        // Update workout attributes
        currentWorkout.setTitle(updatedWorkout.getTitle());
        currentWorkout.setInstructions(updatedWorkout.getInstructions());
        currentWorkout.setGoal(updatedWorkout.getGoal());
        currentWorkout.setExerciceDetailsList(updatedWorkout.getExerciceDetailsList());
        // Save the updated workout
        workoutRepository.save(currentWorkout);
    }
    return currentWorkout;
}


    @PostMapping("/workouts")
    public Workout createWorkout(@RequestBody Workout newWorkout) {
        return workoutRepository.save(newWorkout);
    }
}
