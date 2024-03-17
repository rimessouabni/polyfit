package com.polyfit.polyfit.services;

import java.util.List;

import com.polyfit.polyfit.model.Measurement;

public interface MeasurementService {
    List<Measurement> getAllMeasurements();

    Measurement getMeasurementById(Long id);

    Measurement createMeasurement(Measurement measurement);

    Measurement updateMeasurement(Long id, Measurement measurement);

    void deleteMeasurement(Long id);
}
