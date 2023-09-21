package com.project.Project.repositories;

import com.project.Project.entity.ExerciseEntity;
import com.project.Project.entity.TrainingProgramEntity;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final ProgramRepository programRepository;

    @PostConstruct
    public void initializeDate() {
        TrainingProgramEntity chest = new TrainingProgramEntity("Груди");
        TrainingProgramEntity back = new TrainingProgramEntity("Спина");
        TrainingProgramEntity legs;
        TrainingProgramEntity cardio;
        chest.getExercises().addAll(Arrays.asList(
                new ExerciseEntity(
                        "Жим лежачи",
                        "10 повторювань по 4 підходи",
                        imageToBytes("src/main/resources/exercise-images/bench-press.jpg")),
                new ExerciseEntity(
                        "Жим лежачи",
                        "10 повторювань по 4 підходи",
                        imageToBytes("src/main/resources/exercise-images/bench-press.jpg"))
        ));
        back.getExercises().addAll(Arrays.asList(
                new ExerciseEntity(
                        "Тяга блоку до поясу сидячи",
                        "20 повторювань по 4 підходи",
                        imageToBytes("src/main/resources/exercise-images/bench-press.jpg")),
                new ExerciseEntity(
                        "Тяга блоку до поясу сидячи",
                        "20 повторювань по 4 підходи",
                        imageToBytes("src/main/resources/exercise-images/bench-press.jpg"))
        ));

        programRepository.addProgram(chest);
        programRepository.addProgram(back);
    }

    private byte[] imageToBytes(String imagePath) {
        try {
            return Files.readAllBytes(Paths.get(imagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
