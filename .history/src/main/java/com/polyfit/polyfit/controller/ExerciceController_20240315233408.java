package backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/exercices")
public class ExerciceController {

    @Autowired
    private ExerciceService exerciceService;

    @GetMapping("/{id}")
    public Exercice getExerciceById(@PathVariable Long id) {
        return exerciceService.getExerciceById(id);
    }

    @PostMapping
    public Exercice createExercice(@RequestBody Exercice exercice) {
        return exerciceService.createExercice(exercice);
    }

    @PutMapping("/{id}")
    public Exercice updateExercice(@PathVariable Long id, @RequestBody Exercice exercice) {
        return exerciceService.updateExercice(id, exercice);
    }

    @DeleteMapping("/{id}")
    public void deleteExercice(@PathVariable Long id) {
        exerciceService.deleteExercice(id);
    }
}
