package com.project.Project.entity;

import lombok.Data;

@Data
public class ExerciseEntity {
    private final String name;
    private final Integer[] repetitions;
    private final String image;

    public ExerciseEntity(String name, Integer[] repetitions, String image) {
        this.name = name;
        this.repetitions = repetitions;
        this.image = image;
    }
}
