package com.project.Project.repositories;

import com.project.Project.entity.ExerciseEntity;
import com.project.Project.entity.TrainingProgramEntity;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final ProgramRepository programRepository;

    @PostConstruct
    public void initializeDate() {
        TrainingProgramEntity chest = new TrainingProgramEntity("Chest");
        TrainingProgramEntity back = new TrainingProgramEntity("Back");
        TrainingProgramEntity legs = new TrainingProgramEntity("Legs");
        TrainingProgramEntity cardio = new TrainingProgramEntity("Cardio");
        String BASE_IMAGE_URL = "src/main/resources/exercise-images";

        chest.getExercises().addAll(Arrays.asList(
                exerciseFactory("Bench press", 10, 4,
                        BASE_IMAGE_URL + "/chest/bench-press.jpg"),
                exerciseFactory("Angled barbell press", 12, 4,
                        BASE_IMAGE_URL + "/chest/angle-bench-press.jpg"),
                exerciseFactory("Butterfly", 20, 4,
                        BASE_IMAGE_URL + "/chest/butterfly.jpg"),
                exerciseFactory("Dumbbell press on a horizontal bench", 12, 4,
                        BASE_IMAGE_URL + "/chest/dumbbell-press.jpg"),
                exerciseFactory("Spreading hands at an angle", 15, 4,
                        BASE_IMAGE_URL + "/chest/spreads.jpg"),
                exerciseFactory("Seated dumbbell press", 12, 4,
                        BASE_IMAGE_URL + "/chest/sitting-dumbbell-press.jpg"),
                exerciseFactory("Wave your hands to the sides", 20, 3,
                        BASE_IMAGE_URL + "/chest/sides-swings.jpg"),
                exerciseFactory("Wave your hands in front of you", 15, 4,
                        BASE_IMAGE_URL + "/chest/front-swings.jpg")
        ));
        back.getExercises().addAll(Arrays.asList(
                exerciseFactory("Pulling the block to the waist while sitting", 20, 4,
                        BASE_IMAGE_URL + "/back/sitting-block-pull.jpg"),
                exerciseFactory("Linkage pull while sitting", 15, 4,
                        BASE_IMAGE_URL + "/back/horizontal-cravings.jpeg"),
                exerciseFactory("Pullover with a dumbbell", 12, 4,
                        BASE_IMAGE_URL + "/back/dumbbell-pullover.jpg"),
                exerciseFactory("Inclined barbell pull", 10, 4,
                        BASE_IMAGE_URL + "/back/angle-barbell-pull.jpg"),
                exerciseFactory("Linkage pull from upside", 15, 4,
                        BASE_IMAGE_URL + "/back/vertical-cravings.jpeg"),
                exerciseFactory("Block traction in front of the head", 20, 3,
                        BASE_IMAGE_URL + "/back/block-pull.jpg"),
                exerciseFactory("Swing back at an angle", 20, 4,
                        BASE_IMAGE_URL + "/back/angle-back-swings.jpg"),
                exerciseFactory("Shoulder shrug", 15, 4,
                        BASE_IMAGE_URL + "/back/shoulder-shrug.jpg")
        ));
        legs.getExercises().addAll(Arrays.asList(
                exerciseFactory("Stretching while sitting", 20, 4,
                        BASE_IMAGE_URL + "/legs/sitting-stretch.jpg"),
                exerciseFactory("Leg press", 15, 4,
                        BASE_IMAGE_URL + "/legs/leg-press.jpg"),
                exerciseFactory("Barbell squats", 10, 4,
                        BASE_IMAGE_URL + "/legs/barbell-squats.jpg"),
                exerciseFactory("Lunges", 12 , 4,
                        BASE_IMAGE_URL + "/legs/lunges.jpg"),
                exerciseFactory("Lying flexion", 20, 4,
                        BASE_IMAGE_URL + "/legs/lying-flexion.jpg"),
                exerciseFactory("Sitting flexion", 15, 4,
                        BASE_IMAGE_URL + "/legs/sitting-flexion.jpg"),
                exerciseFactory("Extension", 12, 4,
                        BASE_IMAGE_URL + "/legs/extension.jpg"),
                exerciseFactory("Shin standing", 15, 4,
                        BASE_IMAGE_URL + "/legs/shin-standing.jpg")
        ));
        cardio.getExercises().addAll(Arrays.asList(
                exerciseFactory("Walking on a treadmill", 5,
                        BASE_IMAGE_URL + "/cardio/treadmill.jpg"),
                exerciseFactory("Running with load", 5,
                        BASE_IMAGE_URL + "/cardio/treadmill.jpg"),
                exerciseFactory("Stepper", 5,
                        BASE_IMAGE_URL + "/cardio/stepper.jpg"),
                exerciseFactory("Exercise bike", 5,
                        BASE_IMAGE_URL + "/cardio/exercise-bike.jpg"),
                exerciseFactory("Exercise bike with an easy pace", 5 ,
                        BASE_IMAGE_URL + "/cardio/exercise-bike.jpg")
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

    private String  imageToBytes(String imagePath) {
        try {
            byte[] bytesFromImage = Files.readAllBytes(Paths.get(imagePath));
            return Base64.encodeBase64String(bytesFromImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
