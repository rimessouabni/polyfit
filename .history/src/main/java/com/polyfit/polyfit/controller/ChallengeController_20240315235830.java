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
    public String createChallenge(@RequestBody Challenge challenge) {
        return challengeService.createChallenge(challenge);
    }

    @PutMapping("/{id}")
    public String updateChallenge(@PathVariable Long id, @RequestBody Challenge challenge) {
        return challengeService.updateChallenge(id, challenge);
    }

    @DeleteMapping("/{id}")
    public String deleteChallenge(@PathVariable Long id) {
        challengeService.deleteChallenge(id);
    }
}
