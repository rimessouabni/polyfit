package com.polyfit.polyfit.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class TrainingProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "training_program_workout",
        joinColumns = @JoinColumn(name = "training_program_id"),
        inverseJoinColumns = @JoinColumn(name = "workout_id")
    )
    private List<Workout> workoutSessions;

    // Getters and setters
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
