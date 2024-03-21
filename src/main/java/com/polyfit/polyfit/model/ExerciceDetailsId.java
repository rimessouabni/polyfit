package com.polyfit.polyfit.model;

import java.io.Serializable;

public class ExerciceDetailsId implements Serializable {
    private String exercice;
    private Long workout;

    public String getExercice() {
        return exercice;
    }

    public void setExercice(String exercice) {
        this.exercice = exercice;
    }

    public Long getWorkout() {
        return workout;
    }

    public void setWorkout(Long workout) {
        this.workout = workout;
    }

    // Constructors, equals, hashCode...
}
