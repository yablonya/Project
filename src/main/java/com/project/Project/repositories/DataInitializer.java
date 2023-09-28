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
        TrainingProgramEntity legs = new TrainingProgramEntity("Ноги");;
        TrainingProgramEntity cardio = new TrainingProgramEntity("Кардіо");;
        chest.getExercises().addAll(Arrays.asList(
                exerciseFactory("Жим лежачи", 10, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Жим штанги під кутом", 12, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Метелик", 20, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Жим гантелей на горизонтальній лавці", 12, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Розведення під кутом", 15, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Жим гантелей сидячи", 12, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Махи в сторони", 20, 3,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Махи перед собою", 15, 4,
                        "src/main/resources/exercise-images/bench-press.jpg")
        ));
        back.getExercises().addAll(Arrays.asList(
                exerciseFactory("Тяга блоку до поясу сидячи", 20, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Рижачна тяга сидячи", 15, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Пуловер з гантелею", 12, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Тяга штанги під нахилом", 10, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Рижачна тяга зверху", 15, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Тяга блоку перед головою", 20, 3,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Махи назад під нахилом", 20, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Шраги", 15, 4,
                        "src/main/resources/exercise-images/bench-press.jpg")
        ));
        legs.getExercises().addAll(Arrays.asList(
                exerciseFactory("Розгинання сидячи", 20, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Жим однією ногою", 15, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Присідання зі штангою", 10, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Випади в штанзі", 12 , 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Згинання лежачи", 20, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Згинання сидячи", 15, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Екстензія", 12, 4,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Голінь сидячи", 30, 3,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Голінь стоячи", 15, 4,
                        "src/main/resources/exercise-images/bench-press.jpg")
        ));
        cardio.getExercises().addAll(Arrays.asList(
                exerciseFactory("Ходьба на біговій доріжці", 5,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Біг з нагрузкою", 5,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Степер", 5,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Велотренажер", 5,
                        "src/main/resources/exercise-images/bench-press.jpg"),
                exerciseFactory("Велотренажер з легким темпом", 5 ,
                        "src/main/resources/exercise-images/bench-press.jpg")
        ));

        programRepository.addProgram(chest);
        programRepository.addProgram(back);
        programRepository.addProgram(legs);
        programRepository.addProgram(cardio);
    }

    private ExerciseEntity exerciseFactory(String name, Integer repetitions, Integer approaches, String imagePath) {
        return new ExerciseEntity(name, new Integer[]{repetitions, approaches}, imageToBytes(imagePath));
    }

    private ExerciseEntity exerciseFactory(String name, Integer minutes, String imagePath) {
        return new ExerciseEntity(name, new Integer[]{minutes}, imageToBytes(imagePath));
    }

    private byte[] imageToBytes(String imagePath) {
        try {
            return Files.readAllBytes(Paths.get(imagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
