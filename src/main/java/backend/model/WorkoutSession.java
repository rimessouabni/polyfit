package backend.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "workout_session")
public class WorkoutSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "date", nullable = false)
    private Date date;

    @OneToMany(mappedBy = "workoutSession", cascade = CascadeType.ALL)
    private List<Exercise> exercises;

    // Getters and setters
}