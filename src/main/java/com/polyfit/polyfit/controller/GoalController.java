package com.polyfit.polyfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.polyfit.polyfit.model.Goal;
import com.polyfit.polyfit.services.GoalService;

import java.util.List;

@RestController
public class GoalController {

    @Autowired
    private GoalService goalService;

    @GetMapping("/goals")
    public List<Goal> getAllGoals() {
        return goalService.getAllGoals();
    }

    @GetMapping("/goals/{id}")
    public Goal getGoalById(@PathVariable("id") Long id) {
        return goalService.getGoalById(id);
    }

    @PostMapping("/goals")
    public Goal createGoal(@RequestBody Goal goal) {
        return goalService.createGoal(goal);
    }

    @PutMapping("/goals/{id}")
    public Goal updateGoal(@PathVariable("id") Long id, @RequestBody Goal goal) {
        return goalService.updateGoal(id, goal);
    }

    @DeleteMapping("/goals/{id}")
    public void deleteGoal(@PathVariable("id") Long id) {
        goalService.deleteGoal(id);
    }
}
