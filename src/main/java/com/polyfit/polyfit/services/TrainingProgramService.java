package com.polyfit.polyfit.services;

import java.util.List;

import com.polyfit.polyfit.model.TrainingProgram;

public interface TrainingProgramService {
    List<TrainingProgram> getAllTrainingPrograms();

    TrainingProgram getTrainingProgramById(Long id);

    TrainingProgram createTrainingProgram(TrainingProgram program);

    TrainingProgram updateTrainingProgram(Long id, TrainingProgram program);

    void deleteTrainingProgram(Long id);
}
