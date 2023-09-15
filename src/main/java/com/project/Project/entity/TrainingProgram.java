package com.project.Project.entity;

import java.util.ArrayList;
import java.util.List;

public class TrainingProgram {
    public String name;
    public ArrayList<ExerciseEntity> exercises;

    public TrainingProgram(String name, ArrayList<ExerciseEntity> exercises) {
        this.name = name;
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public ArrayList<ExerciseEntity> getExercises() {
        return exercises;
    }
}
