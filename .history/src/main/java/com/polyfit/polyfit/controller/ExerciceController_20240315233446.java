package com.polyfit.polyfit.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/exercices")
public class ExerciceController {

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
