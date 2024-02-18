package backend.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workout_session_id", nullable = false)
    private WorkoutSession workoutSession;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sets", nullable = false)
    private int sets;

    @Column(name = "reps", nullable = false)
    private int reps;

    @Column(name = "weight")
    private double weight; // Poids utilisé pour l'exercice

    @Column(name = "notes", length = 1000)
    private String notes; // Notes supplémentaires sur l'exercice

    // Getters and setters
}