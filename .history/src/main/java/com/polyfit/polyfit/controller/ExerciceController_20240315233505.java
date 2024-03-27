package com.polyfit.polyfit.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/exercices")
public class ExerciceController {

    @GetMapping("/{id}")
    public String getExerciceById(@PathVariable Long id) {
        return exerciceService.getExerciceById(id);
    }

    @PostMapping
    public String createExercice(@RequestBody Exercice exercice) {
        return exerciceService.createExercice(exercice);
    }

    @PutMapping("/{id}")
    public String updateExercice(@PathVariable Long id, @RequestBody Exercice exercice) {
        return exerciceService.updateExercice(id, exercice);
    }

    @DeleteMapping("/{id}")
    public void deleteExercice(@PathVariable Long id) {
        exerciceService.deleteExercice(id);
    }
}
