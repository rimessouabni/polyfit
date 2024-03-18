package com.polyfit.polyfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.polyfit.polyfit.model.Measurement;
import com.polyfit.polyfit.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    @Autowired
    private MeasurementRepository measurementRepository;

    @GetMapping("/get-all")
    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Measurement> getSingleMeasurement(@PathVariable("id") Long id) {
        Optional<Measurement> measurement = measurementRepository.findById(id);
        return measurement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public Measurement addMeasurement(@RequestBody Measurement newMeasurement) {
        return measurementRepository.save(newMeasurement);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Measurement> updateMeasurement(@PathVariable("id") Long id, @RequestBody Measurement updatedMeasurement) {
        if (!measurementRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedMeasurement.setId(id);
        return ResponseEntity.ok(measurementRepository.save(updatedMeasurement));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteMeasurement(@PathVariable("id") Long id) {
        if (measurementRepository.existsById(id)) {
            measurementRepository.deleteById(id);
            return ResponseEntity.ok("Measurement deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Measurement not found");
    }
}
