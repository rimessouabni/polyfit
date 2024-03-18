package com.polyfit.polyfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.polyfit.polyfit.model.Goal;
import com.polyfit.polyfit.repository.GoalRepository;
import com.polyfit.polyfit.services.GoalService;

import java.util.List;

@RestController
public class GoalController {

    @Autowired
    private GoalRepository goalRepository;

    @GetMapping("/get-all-goals")
    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    @GetMapping("/get-goal/{id}")
    public Goal getGoalById(@PathVariable("id") Long id) {
        return goalRepository.findById(id).orElse(null);
    }

    //@PostMapping("/goals")
    //public Goal createGoal(@RequestBody Goal goal) {
    //    return goalRepository.createGoal(goal);
    //}

    //@PutMapping("/goals/{id}")
    //public Goal updateGoal(@PathVariable("id") Long id, @RequestBody Goal goal) {
    //    return goalRepository.updateGoal(id, goal);
    //}

    @DeleteMapping("/remove-goal/{id}")
    public boolean deleteGoal(@PathVariable("id") Long id) {
        if (goalRepository.existsById(id)) {
            goalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
