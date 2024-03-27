package com.polyfit.polyfit.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    @GetMapping
    public String getAllChallenges() {
        return "Get all challenges";
    }
    @GetMapping("/{id}")
    public String getChallengeById(@PathVariable Long id) {
        return "Get challenge with ID: " + id;
    }

    @PostMapping
    public String createChallenge(@RequestBody String challenge) {
        return "Create a new challenge: " + challenge;
    }

    @PutMapping("/{id}")
    public String updateChallenge(@PathVariable Long id, @RequestBody String challenge) {
        return "Update challenge with ID " + id + ": " + challenge;
    }

    @DeleteMapping("/{id}")
    public String deleteChallenge(@PathVariable Long id) {
        return "Delete challenge with ID: " + id;
    }
}
