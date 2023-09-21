package com.project.Project.entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class TrainingProgramEntity {
    private String name;
    private final ArrayList<ExerciseEntity> exercises = new ArrayList<>();

    public TrainingProgramEntity(String name) {
        this.name = name;
    }
}
