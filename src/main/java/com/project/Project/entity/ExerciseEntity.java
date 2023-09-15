package com.project.Project.entity;

public class ExerciseEntity {
    public String name;
    public String repetitions;

    public ExerciseEntity(String name, String repetitions) {
        this.name = name;
        this.repetitions = repetitions;
    }

    public String getName() {
        return name;
    }

    public String getRepetitions() {
        return repetitions;
    }
}
