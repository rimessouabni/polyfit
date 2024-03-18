package com.polyfit.polyfit.model;

import jakarta.persistence.*;

@Entity
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "weight")
    private double weight;

    @Column(name = "height")
    private double height;

    @Column(name = "body_fat_percentage")
    private double bodyFatPercentage;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBodyFatPercentage() {
        return bodyFatPercentage;
    }

    public void setBodyFatPercentage(double bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
    }
}
