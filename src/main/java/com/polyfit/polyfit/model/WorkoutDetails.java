package com.polyfit.polyfit.model;

import jakarta.persistence.*;

@Entity
@Table(name = "training_program_workouts")
public class WorkoutDetails {

    
    @ManyToOne
    @JoinColumn(name = "training_program_id")
    private TrainingProgram trainingProgram;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @Id
    @Column(name = "jour_de_semaine")
    private String jourDeSemaine;


    // Constructors
    public WorkoutDetails() {
    }

    public WorkoutDetails(Workout workout, String jour) {
        this.workout = workout;
        this.jourDeSemaine = jour;
    }

    // Getters and setters

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }


    public String getjourDeSemaine() {
        return this.jourDeSemaine;
    }

    public void setjourDeSemaine(String jour) {
        this.jourDeSemaine = jour;
    }
    
}
