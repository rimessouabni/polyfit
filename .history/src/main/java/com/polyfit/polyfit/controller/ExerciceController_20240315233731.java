package com.polyfit.polyfit.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/exercices")
public class ExerciceController {


    @GetMapping
    public String getAllExercices() {
        return "Get all exercices";
    }

    @GetMapping("/{id}")
    public String getExerciceById(@PathVariable Long id) {
        return "Get exercice with ID: " + id;
    }

    @PostMapping
    public String createExercice(@RequestBody String exercice) {
        return exerciceService.createExercice(exercice);
    }

    @PutMapping("/{id}")
    public String updateExercice(@PathVariable Long id, @RequestBody String exercice) {
        return exerciceService.updateExercice(id, exercice);
    }

    @DeleteMapping("/{id}")
    public void deleteExercice(@PathVariable Long id) {
        exerciceService.deleteExercice(id);
    }
}
