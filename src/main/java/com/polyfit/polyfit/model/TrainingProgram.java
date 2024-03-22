package com.polyfit.polyfit.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "training_programs")
public class TrainingProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private String startingDate;

    

    @OneToMany(mappedBy = "trainingProgram", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkoutDetails> workoutDetailsList;

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

    public List<WorkoutDetails> getworkoutDetailsList() {
        return workoutDetailsList;
    }

    public void setworkoutDetailsList(List<WorkoutDetails> workoutDetailsList) {
        this.workoutDetailsList = workoutDetailsList;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }
    
    public boolean hasWorkoutOnDay(String dayName) {
        if (getworkoutDetailsList() == null) {
            return false;
        }

        return getworkoutDetailsList().stream()
            .anyMatch(workoutDetail -> workoutDetail.getjourDeSemaine().equals(dayName));
    }
    
    public String nameOfTheWorkoutAfterComparaison(String dayName){
        return getworkoutDetailsList()
        .stream()
        .filter(workoutDetail -> workoutDetail.getjourDeSemaine().equals(dayName))
        .findFirst()
        .map(workoutDetail -> workoutDetail.getWorkout().getTitle()).orElse("Repos");
    }
}