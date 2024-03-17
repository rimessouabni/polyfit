package com.polyfit.polyfit.model;

import java.util.List;

public class TrainingProgram {
    private Long id;
    private String name;
    private List<Workout> workoutSessions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Workout> getWorkoutSessions() {
        return workoutSessions;
    }

    public void setWorkoutSessions(List<Workout> workoutSessions) {
        this.workoutSessions = workoutSessions;
    }
}
