package com.polyfit.polyfit.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "exercices")
public class Exercice {
    @Id
    @Column(name = "title")
    private String title;

    @Column(name = "icon_path")
    private String iconPath;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "exercice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciceDetails> exerciceDetailsList;

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ExerciceDetails> getExerciceDetailsList() {
        return exerciceDetailsList;
    }

    public void setExerciceDetailsList(List<ExerciceDetails> exerciceDetailsList) {
        this.exerciceDetailsList = exerciceDetailsList;
    }
}
