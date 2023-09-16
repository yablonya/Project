package com.project.Project.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
public class TrainingProgramEntity {
    private final String name;
    private final ArrayList<ExerciseEntity> exercises;
}
