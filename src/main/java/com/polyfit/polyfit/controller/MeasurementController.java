package com.polyfit.polyfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.polyfit.polyfit.model.Measurement;
import com.polyfit.polyfit.services.MeasurementService;

import java.util.List;

@RestController
public class MeasurementController {

    @Autowired
    private MeasurementService measurementService;

    @GetMapping("/measurements")
    public List<Measurement> getAllMeasurements() {
        return measurementService.getAllMeasurements();
    }

    @GetMapping("/measurements/{id}")
    public Measurement getMeasurementById(@PathVariable("id") Long id) {
        return measurementService.getMeasurementById(id);
    }

    @PostMapping("/measurements")
    public Measurement createMeasurement(@RequestBody Measurement measurement) {
        return measurementService.createMeasurement(measurement);
    }

    @PutMapping("/measurements/{id}")
    public Measurement updateMeasurement(@PathVariable("id") Long id, @RequestBody Measurement measurement) {
        return measurementService.updateMeasurement(id, measurement);
    }

    @DeleteMapping("/measurements/{id}")
    public void deleteMeasurement(@PathVariable("id") Long id) {
        measurementService.deleteMeasurement(id);
    }
}
