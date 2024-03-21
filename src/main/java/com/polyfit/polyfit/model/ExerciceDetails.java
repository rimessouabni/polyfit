package com.polyfit.polyfit.model;

import jakarta.persistence.*;

@Entity
@Table(name = "workout_exercices")
@IdClass(ExerciceDetailsId.class)
public class ExerciceDetails {

    @Id
    @ManyToOne
    @JoinColumn(name = "exercice_title")
    private Exercice exercice;

    @Id
    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @Column(name = "sets_number")
    private Integer sets;

    @Column(name = "reps_number")
    private Integer reps;

    // Constructors
    public ExerciceDetails() {
    }

    public ExerciceDetails(Exercice exercice, Workout workout, Integer sets, Integer reps) {
        this.exercice = exercice;
        this.workout = workout;
        this.sets = sets;
        this.reps = reps;
    }

    // Getters and setters
    public Exercice getExercice() {
        return exercice;
    }

    public void setExercice(Exercice exercice) {
        this.exercice = exercice;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }
    
    // Optional: toString() method for debugging
    @Override
    public String toString() {
        return "ExerciceDetails{" +
                "exercice=" + exercice +
                ", workout=" + workout +
                ", sets=" + sets +
                ", reps=" + reps +
                '}';
    }
}
