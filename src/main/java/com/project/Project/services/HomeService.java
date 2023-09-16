package com.project.Project.services;

import com.project.Project.entity.ExerciseEntity;
import com.project.Project.entity.TrainingProgramEntity;
import com.project.Project.repositories.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HomeService {
    private ProgramRepository programRepository = new ProgramRepository();

    public ArrayList<TrainingProgramEntity> getAllPrograms() {
        return programRepository.getPrograms();
    }

    public Optional<TrainingProgramEntity> getProgram(String name) {
        return programRepository.getTrainingProgram(name);
    }

    public void createAllPrograms() {
        TrainingProgramEntity chest = new TrainingProgramEntity("Груди", new ArrayList<ExerciseEntity>());
        TrainingProgramEntity back = new TrainingProgramEntity("Спина", new ArrayList<ExerciseEntity>());
        TrainingProgramEntity legs;
        TrainingProgramEntity cardio;
        chest.getExercises().addAll(Arrays.asList(
                new ExerciseEntity(
                        "Жим лежачи",
                        "10 повторювань по 4 підходи"),
                new ExerciseEntity(
                        "Жим лежачи",
                        "10 повторювань по 4 підходи")
        ));
        back.getExercises().addAll(Arrays.asList(
                new ExerciseEntity(
                        "Тяга блоку до поясу сидячи",
                        "20 повторювань по 4 підходи"),
                new ExerciseEntity(
                        "Тяга блоку до поясу сидячи",
                        "20 повторювань по 4 підходи")
        ));

        programRepository.addProgram(chest);
        programRepository.addProgram(back);
    }
}
