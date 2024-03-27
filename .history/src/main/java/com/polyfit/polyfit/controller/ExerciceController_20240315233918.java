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
        return "Create a new exercice: " + exercice;
    }

    @PutMapping("/{id}")
    public String updateExercice(@PathVariable Long id, @RequestBody String exercice) {
        return "Update exercice with ID " + id + ": " + exercice;
    }

    @DeleteMapping("/{id}")
    public String deleteExercice(@PathVariable Long id) {
        return "Delete exercice with ID: " + id;
    }
}
