package com.polyfit.polyfit.services;

import java.util.List;

import com.polyfit.polyfit.model.Goal;

public interface GoalService {

    List<Goal> getAllGoals();

    Goal getGoalById(Long id);

    Goal createGoal(Goal goal);

    Goal updateGoal(Long id, Goal goal);

    void deleteGoal(Long id);
}