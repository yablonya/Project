package com.project.Project.entity;

import lombok.Data;

@Data
public class ExerciseEntity {
    private final String name;
    private final Integer[] repetitions;
    private final byte[] image;

    public ExerciseEntity(String name, Integer[] repetitions, byte[] image) {
        this.name = name;
        this.repetitions = repetitions;
        this.image = image;
    }
}
